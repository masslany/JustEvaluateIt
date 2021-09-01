package com.masslany.justevaluateit.data.local.entity.relations

import androidx.room.Entity

@Entity(primaryKeys = ["productId", "reviewerId"])
data class ReviewerProductCrossRef(
    val reviewerId: Int,
    val productId: Int
)