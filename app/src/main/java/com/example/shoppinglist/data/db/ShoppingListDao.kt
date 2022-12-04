package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.db.entities.ShoppingList

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(list : ShoppingList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingList)

    @Transaction
    @Query("SELECT * FROM shopping_lists")
    suspend fun getAllLists() : LiveData<List<ShoppingList>>

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE schoolID = :listID")
    suspend fun getListWithItems(listID : Int) : List<ListWithItems>
}