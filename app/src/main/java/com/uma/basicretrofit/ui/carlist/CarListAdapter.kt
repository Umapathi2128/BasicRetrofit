package com.uma.basicretrofit.ui.carlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uma.basicretrofit.R
import com.uma.basicretrofit.data.AutoUpdater
import com.uma.basicretrofit.data.DataItem
import kotlinx.android.synthetic.main.car_list.view.*
import kotlin.properties.Delegates

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */
class CarListAdapter : RecyclerView.Adapter<CarListAdapter.CarListViewHolder>(), AutoUpdater {

    var items: List<DataItem> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        autoNotify(oldValue, newValue) { o, n -> o.id == n.id }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        return CarListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.car_list, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    class CarListViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(item: DataItem) = with(view) {
            txtTitle.text = item.title
            txtDescription.text = item.description
            Glide.with(this.context).load(item.imageUrlTumbnail).into(imgCar)
        }
    }


}