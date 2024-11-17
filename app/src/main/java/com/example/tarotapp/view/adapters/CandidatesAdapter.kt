package com.example.tarotapp.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tarotapp.databinding.ItemCandidatesBinding
import com.example.tarotapp.entitty.Candidate

class CandidatesAdapter(context: Context) : RecyclerView.Adapter<CandidatesAdapter.CandidateViewHolder>() {
    private val candidates: MutableList<Candidate> = mutableListOf()
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var listener: AdapterView.OnItemClickListener? = null

    class CandidateViewHolder(val view: View) : ViewHolder(view) {
        var binding: ItemCandidatesBinding? = DataBindingUtil.bind(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Candidate>) {
        candidates.clear()
        candidates.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val binding = ItemCandidatesBinding.inflate(inflater, parent, false)
        return CandidateViewHolder(binding.root)
    }

    override fun getItemCount(): Int = candidates.size

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        val candidate = candidates[position]
        holder.binding?.candidate = candidate
    }
}