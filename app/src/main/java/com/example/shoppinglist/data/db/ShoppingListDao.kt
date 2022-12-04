package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist.data.db.entities.ShoppingList

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(list : ShoppingList)

    @Delete
    suspend fun delete(item : ShoppingList)

    @Query("SELECT * FROM shopping_lists")
    fun getAllLists() : LiveData<List<ShoppingList>>
}