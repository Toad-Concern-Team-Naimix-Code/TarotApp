package com.example.tarotapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentCandidateProfileBinding

class FragmentCandidateProfile : Fragment() {

    private var _binding: FragmentCandidateProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCandidateProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateCompatibility.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCandidateProfile_to_fragmentCompatibilityCalculation)
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