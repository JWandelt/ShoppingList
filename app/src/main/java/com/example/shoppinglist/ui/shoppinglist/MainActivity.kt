package com.example.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingListRepository
import com.example.shoppinglist.data.repositories.ShoppingRepository
import com.example.shoppinglist.other.ShoppingItemAdapter
import com.example.shoppinglist.other.ShoppingListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        //val repository = ShoppingRepository(database)
        val repository = ShoppingListRepository(database)
        //val factory = ShoppingViewModelFactory(repository)
        val factory = ShoppingListViewModelFactory(repository)

        //val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingListViewModel::class.java)

        //val adapter = ShoppingItemAdapter(listOf(), viewModel)
        val adapter = ShoppingListAdapter(listOf(), viewModel)

        //val rv = findViewById<RecyclerView>(R.id.rvShoppingItems)
        //val fab = findViewById<FloatingActionButton>(R.id.fab)
        val rv = findViewById<RecyclerView>(R.id.rvShoppingItems)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

//        viewModel.getAllShoppingItems().observe(this, Observer{
//            adapter.items = it
//            adapter.notifyDataSetChanged()
//        })
        viewModel.getAllLists().observe(this, Observer{
            adapter.lists = it
            adapter.notifyDataSetChanged()
        })

//        fab.setOnClickListener{
//            AddShoppingItemDialog(this,
//            object : AddDialogLIstener{
//                override fun onAddButtonClicked(item : ShoppingItem){
//                    viewModel.upsert(item)
//                }
//            }).show()
//        }
    }
}