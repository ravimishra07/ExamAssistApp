package com.examassistapp.data.remote

import com.examassistapp.models.Document
import com.examassistapp.utils.Constants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DocumentDatabase {
    private val fireStore = FirebaseFirestore.getInstance()
    private val docCollection = fireStore.collection(Constants.DOCUMENT_COLLECTION)

    suspend fun getAllDocuments(): List<Document> {
        return try {
            docCollection.get().await().toObjects(Document::class.java)
        } catch(e: Exception) {
            emptyList()
        }
    }
}