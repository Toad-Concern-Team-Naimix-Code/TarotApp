package com.example.tarotapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentCandidatesBinding
import com.example.tarotapp.entitty.Candidate
import com.example.tarotapp.view.adapters.CandidatesAdapter

class FragmentCandidates : Fragment() {

    private var _binding: FragmentCandidatesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCandidatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCandidates2_to_fragmentAddCandidate)
        }
        val adapter = CandidatesAdapter(requireContext())
        adapter.listener = View.OnClickListener {
            findNavController().navigate(R.id.action_fragmentCandidates2_to_fragmentCandidateProfile)
        }
        adapter.setItems(getItems())
        binding.candidates.adapter = adapter
    }

    private fun getItems(): List<Candidate> {
        val colleague = Candidate(
            cardIcon = ResourcesCompat.getDrawable(resources, R.drawable.jester, null),
            name = "Гэндальф Серый",
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