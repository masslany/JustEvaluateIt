package com.masslany.justevaluateit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Review(
    @PrimaryKey(autoGenerate = true)
    val reviewId: Int = 0,
    val reviewerId: Int,
    val productId: String,
    val grade: Float
)