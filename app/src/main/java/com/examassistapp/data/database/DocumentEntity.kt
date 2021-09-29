package com.examassistapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.examassistapp.models.Document
import com.examassistapp.utils.Constants.Companion.DOCUMENT_TABLE

@Entity(tableName = DOCUMENT_TABLE)
class DocumentEntity(
    var document: List<Document>
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
