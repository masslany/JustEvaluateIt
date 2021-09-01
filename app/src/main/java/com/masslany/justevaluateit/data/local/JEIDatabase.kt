package com.masslany.justevaluateit.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.data.local.entity.Review
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.data.local.entity.dao.CategoryDao
import com.masslany.justevaluateit.data.local.entity.dao.ProductDao
import com.masslany.justevaluateit.data.local.entity.dao.ReviewDao
import com.masslany.justevaluateit.data.local.entity.dao.ReviewerDao
import com.masslany.justevaluateit.data.local.entity.relations.ReviewerProductCrossRef

@Database(
    entities = [
        Category::class,
        Product::class,
        Reviewer::class,
        Review::class,
        ReviewerProductCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class JEIDatabase : RoomDatabase() {

    abstract val categoryDao: CategoryDao
    abstract val productDao: ProductDao
    abstract val reviewDao: ReviewDao
    abstract val reviewerDao: ReviewerDao

    companion object {
        private const val DATABASE_NAME = "jei_db"

        @Volatile
        private var INSTANCE: JEIDatabase? = null

        fun getInstance(context: Context): JEIDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    JEIDatabase::class.java,
                    DATABASE_NAME
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}