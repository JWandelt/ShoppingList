package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogLIstener {
    fun onAddButtonClicked(item : ShoppingItem)
}