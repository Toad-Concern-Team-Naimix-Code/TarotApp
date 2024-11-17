package com.example.tarotapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentColleguesBinding
import com.example.tarotapp.entitty.Colleague
import com.example.tarotapp.view.adapters.ColleagueAdapter

class FragmentColleagues : Fragment() {

    private var _binding: FragmentColleguesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColleguesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ColleagueAdapter(requireContext())
        adapter.setItems(getItems())
        binding.colleagues.adapter = adapter
    }

    fun getItems(): List<Colleague> {
        val colleague = Colleague(
            cardIcon = ResourcesCompat.getDrawable(resources, R.drawable.jester, null),
            name = "Бильбо Бэггинс",
            company = "OOO Таро"
        )
        val list = mutableListOf(colleague)
        for (i in 0..10) {
            list.add(colleague)
        }
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}