package com.masslany.justevaluateit.data.local.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Product

data class CategoryWithProducts(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "productId"
    )
    val products: List<Product>
)
