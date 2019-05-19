package com.rahulverlekar.test.basecode.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rahulverlekar.test.basecode.BR
import com.rahulverlekar.test.basecode.R

class DataBindingVH(view: View) : RecyclerView.ViewHolder(view) {

    lateinit var binding: ViewDataBinding

    companion object {

        fun <E> createVH(parent: ViewGroup, @LayoutRes layoutId: Int): DataBindingVH {
            val inflater = LayoutInflater.from(parent.context)
            val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, parent, false)
            val viewHolder = DataBindingVH(binding.root)
            viewHolder.binding = binding
            return viewHolder
        }
    }
}

interface RecyclerViewCallback {
    //This will be the base interface for any callback that will be passed to the view holder
}

class LinearLayoutAdapter<E>(val layoutId: Int) : RecyclerView.Adapter<DataBindingVH>(), RecyclerViewCallback {

    var dataSource: MutableList<E> = arrayListOf()
    var callback: RecyclerViewCallback? = null

    override fun onBindViewHolder(holder: DataBindingVH, position: Int) {
        if (callback != null) {
            holder.binding.setVariable(BR.callback, callback)
        }
        holder.binding.setVariable(BR.model, dataSource[position])
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingVH {
        return DataBindingVH.createVH<E>(parent, layoutId)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

}

//These is an extension functions that will allow us to bind datasource to the recylerview

fun <E> RecyclerView.addDataSource(dataSource: MutableList<E>, @LayoutRes layoutId: Int, callback: RecyclerViewCallback?, @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL) {
    val adapter = LinearLayoutAdapter<E>(R.layout.item_post_summary)
    adapter.callback = callback
    adapter.dataSource = dataSource
    layoutManager = LinearLayoutManager(context)
    adapter.notifyDataSetChanged()
    setAdapter(adapter)
}