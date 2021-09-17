package com.masslany.justevaluateit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    val productId: String,
    val categoryId: Int,
    val name: String,
    val barcode: String,
    val photo: String?,
    val description: String,
    val timeAdded: Long = System.currentTimeMillis()
)
