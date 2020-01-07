package com.uma.basicretrofit.data

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */
interface AutoUpdater {

    fun <T> RecyclerView.Adapter<*>.autoNotify(
        old : List<T>,
        new : List<T>,
        compare : (T,T) -> Boolean
    ){
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(old[oldItemPosition], new[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

            override fun getOldListSize() = old.size

            override fun getNewListSize() = new.size
        })

        diff.dispatchUpdatesTo(this)
    }
}