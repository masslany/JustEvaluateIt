package com.masslany.justevaluateit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.masslany.justevaluateit.data.local.dao.CategoryDao
import com.masslany.justevaluateit.data.local.dao.ProductDao
import com.masslany.justevaluateit.data.local.dao.ReviewDao
import com.masslany.justevaluateit.data.local.dao.ReviewerDao
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.data.local.entity.Review
import com.masslany.justevaluateit.data.local.entity.Reviewer

@Database(
    entities = [
        Category::class,
        Product::class,
        Reviewer::class,
        Review::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class JEIDatabase : RoomDatabase() {

    abstract val categoryDao: CategoryDao
    abstract val productDao: ProductDao
    abstract val reviewDao: ReviewDao
    abstract val reviewerDao: ReviewerDao
}
