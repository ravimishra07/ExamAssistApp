package com.examassistapp.models

import com.google.gson.annotations.SerializedName

data class Document(
    @SerializedName("avg_rating")
    val averageRating: String,

    @SerializedName("branch")
    val branch: String,

    @SerializedName("doc_id")
    val documentId: String,

    @SerializedName("doc_type")
    val documentType: Int,

    @SerializedName("is_premium")
    val isPremium: String,

    @SerializedName("paper_year")
    val paperYear: String,

    @SerializedName("rating_count")
    val ratingCount: String,

    @SerializedName("sub_count_aktu")
    val subject_code_aktu: String,

    @SerializedName("sub_count_mjpru")
    val subject_code_mjpru: String,

    @SerializedName("sub_count")
    val subject_code: String,

    @SerializedName("tag")
    val documentTags: String,

    @SerializedName("title")
    val documentTitle: String,

    @SerializedName("upload_date")
    val uploadDate: String,

    @SerializedName("uploader_id")
    val uploaderId: String,

    @SerializedName("uploader_name")
    val uploaderName: String,

    @SerializedName("view_count")
    val viewCount: String,
    )
