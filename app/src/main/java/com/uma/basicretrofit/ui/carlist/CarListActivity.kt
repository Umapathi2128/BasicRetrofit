package com.uma.basicretrofit.ui.carlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.uma.basicretrofit.R
import kotlinx.android.synthetic.main.activity_car_list.*

class CarListActivity : AppCompatActivity() {

    lateinit var viewModel: CarListViewModel
    var adapter = CarListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)

        // view model initialising...
        viewModel = ViewModelProviders.of(this).get(CarListViewModel::class.java)
        // set data to adapter...
        viewModel.list.observe(this, Observer {
            adapter.items = it
        })

        initialiseRecycler()
    }

    /**
     * Initialising recyclerview
     * setting adapter
     */
    private fun initialiseRecycler(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sync ->{
                viewModel.checkWebService()
            }
            else ->{}
         }

        return true
    }
}
