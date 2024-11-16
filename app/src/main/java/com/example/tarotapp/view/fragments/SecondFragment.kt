package com.example.tarotapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val companies = resources.getStringArray(R.array.companies)
        val companiesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_intem, companies)
        binding.spinnerCompany.setAdapter(companiesAdapter)


        val departments = resources.getStringArray(R.array.departments)
        val departmentsAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_intem, departments)
        binding.spinnerDepartment.setAdapter(departmentsAdapter)


        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_navigation_graph)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}