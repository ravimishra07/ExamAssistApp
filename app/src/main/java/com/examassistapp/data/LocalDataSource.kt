package com.examassistapp.data


import com.examassistapp.data.database.DocumentDao
import com.examassistapp.data.database.DocumentEntity
import com.examassistapp.models.Document
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val documentDoa: DocumentDao
) {

    fun readDocument(): Flow<List<DocumentEntity>> {
        return documentDoa.readDocument()
    }

    suspend fun insertRecipes(documentEntity: DocumentEntity) {
        documentDoa.insertDocument(documentEntity)
    }

    suspend fun deleteFavoriteRecipe(documentEntity: DocumentEntity) {
        documentDoa.deleteDocument(documentEntity)
    }

    suspend fun deleteAllDocuments() {
        documentDoa.deleteAllDocuments()
    }
}