package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.db.entities.ShoppingList

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list : ShoppingList)

    @Delete
    suspend fun delete(list : ShoppingList)

    @Transaction
    @Query("SELECT * FROM shopping_lists")
    fun getAllLists() : LiveData<List<ShoppingList>>

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE listID = :listID")
    fun getListWithItems(listID : Int) : List<ListWithItems>
}