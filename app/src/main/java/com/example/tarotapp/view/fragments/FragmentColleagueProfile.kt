package com.example.tarotapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentColleagueProfileBinding

class FragmentColleagueProfile: Fragment() {

    private var _binding: FragmentColleagueProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColleagueProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateCompatibility.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentColleagueProfile_to_fragmentCompatibilityCalculation2)
        }
        binding.back.root.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}