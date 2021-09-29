package com.examassistapp.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.*
import com.examassistapp.data.Repository
import com.examassistapp.data.database.DocumentEntity
import com.examassistapp.models.Document
import com.examassistapp.utils.NetworkResult

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    /** ROOM DATABASE */

    val readDocument: LiveData<List<DocumentEntity>> = repository.local.readDocument().asLiveData()

    private fun insertDocument (documentEntity: DocumentEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertRecipes(documentEntity)
        }

    fun deleteDocument(documentEntity: DocumentEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteFavoriteRecipe(documentEntity)
        }

    fun deleteAllDocument() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteAllDocuments()
        }

    /** Firestore */
    var recipesResponse: MutableLiveData<NetworkResult<List<Document>>> = MutableLiveData()

    fun getAllDocuments() = viewModelScope.launch {
        getRecipesSafeCall()
    }

    private suspend fun getRecipesSafeCall() {
        recipesResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getAllDocuments()
                recipesResponse.value = handleFoodRecipesResponse(response)

                val doc = recipesResponse.value!!.data
                if(doc != null) {
                    offlineCacheDocuments(doc)
                }
            } catch (e: Exception) {
                recipesResponse.value = NetworkResult.Error("Recipes not found.")
            }
        } else {
            recipesResponse.value = NetworkResult.Error("No Internet Connection.")
        }
    }

    private fun offlineCacheDocuments(docList: List<Document>) {
        val recipesEntity = DocumentEntity(docList)
        insertDocument(recipesEntity)
    }


    private fun handleFoodRecipesResponse(response: List<Document>?): NetworkResult<List<Document>> {
        response?.let { docList ->
            return if(!docList.isNullOrEmpty()){
                NetworkResult.Success(docList)
            }else{
                NetworkResult.Error("No files found")
            }

        }?.run{
            return NetworkResult.Error("response not found")
        }
        return NetworkResult.Error("No files found")
    }


    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}