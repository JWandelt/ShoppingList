package com.example.shoppinglist.data.db

import androidx.room.Embedded
import androidx.room.Relation
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.db.entities.ShoppingList

data class ListWithItems(
    @Embedded val list : ShoppingList,
    @Relation(
        parentColumn = "schoolID",
        entityColumn = "list_id"
    )
    val items : List<ShoppingItem>
)
