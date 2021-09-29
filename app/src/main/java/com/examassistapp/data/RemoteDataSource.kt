package com.examassistapp.data

import com.examassistapp.data.remote.DocumentDatabase
import com.examassistapp.models.Document
import com.examassistapp.utils.Constants.Companion.DOCUMENT_COLLECTION

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private  val documentDatabase: DocumentDatabase
){
    suspend fun getAllDocuments(): List<Document> {
        return documentDatabase.getAllDocuments()
    }
}