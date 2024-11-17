package com.example.tarotapp.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tarotapp.databinding.ItemColleagueBinding
import com.example.tarotapp.entitty.Colleague

class ColleagueAdapter(context: Context) : RecyclerView.Adapter<ColleagueAdapter.ColleagueViewHolder>() {
    private val colleague: MutableList<Colleague> = mutableListOf()
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var listener: View.OnClickListener? = null

    class ColleagueViewHolder(val view: View) : ViewHolder(view) {
        var binding: ItemColleagueBinding? = DataBindingUtil.bind(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Colleague>) {
        colleague.clear()
        colleague.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColleagueViewHolder {
        val binding = ItemColleagueBinding.inflate(inflater, parent, false)
        return ColleagueViewHolder(binding.root)
    }

    override fun getItemCount(): Int = colleague.size

    override fun onBindViewHolder(holder: ColleagueViewHolder, position: Int) {
        val colleague = colleague[position]
        holder.binding?.collegue = colleague
        holder.binding?.root?.setOnClickListener { view ->
            listener?.onClick(view)
        }
    }
}