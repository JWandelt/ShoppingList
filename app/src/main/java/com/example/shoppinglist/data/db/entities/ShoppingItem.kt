package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
//    @ColumnInfo(name = "list_number")
//    var list : Int,
//    @ColumnInfo(name = "list_name")
//    var listName : String,
    @ColumnInfo(name = "item_name")
    var name : String,
    @ColumnInfo(name = "item_amount")
    var amount : Int)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}