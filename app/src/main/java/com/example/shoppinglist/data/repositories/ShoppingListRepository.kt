package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingList

class ShoppingListRepository(
    private val db : ShoppingDatabase
) {
    suspend fun upsert(list : ShoppingList) = db.getShoppingListDao().upsert(list)

    suspend fun delete(list : ShoppingList) = db.getShoppingListDao().delete(list)

    fun getAllLists() = db.getShoppingListDao().getAllLists()
}