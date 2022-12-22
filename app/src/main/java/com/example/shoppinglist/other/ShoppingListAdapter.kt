package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingList
import com.example.shoppinglist.ui.shoppinglist.ShoppingListViewModel

class ShoppingListAdapter(
    var lists : List<ShoppingList>,
    private val viewModel : ShoppingListViewModel
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>(){

    inner class ShoppingListViewHolder(listView : View) : RecyclerView.ViewHolder(listView){}

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ShoppingListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list, parent, false)
        return ShoppingListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val curList = lists[position]

        holder.itemView.findViewById<TextView>(R.id.tv_listName).text = curList.name

        holder.itemView.findViewById<ImageView>(R.id.iv_delete).setOnClickListener {
            viewModel.delete(curList)
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}