package com.examassistapp.data

import com.examassistapp.models.Document
import com.examassistapp.utils.Constants.Companion.DOCUMENT_COLLECTION

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class RemoteDataSource{

    private val fireStore = FirebaseFirestore.getInstance()
    private val docCollection = fireStore.collection(DOCUMENT_COLLECTION)

    suspend fun getAllDocuments(): List<Document> {
        return try {
            docCollection.get().await().toObjects(Document::class.java)
        } catch(e: Exception) {
            emptyList()
        }
    }
}