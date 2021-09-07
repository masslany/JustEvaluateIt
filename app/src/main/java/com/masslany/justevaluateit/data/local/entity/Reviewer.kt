package com.masslany.justevaluateit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reviewer(
    @PrimaryKey(autoGenerate = true)
    val reviewerId: Int = 0,
    val name: String,
    val photo: String?
)
