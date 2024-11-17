package com.example.tarotapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tarotapp.R
import com.example.tarotapp.databinding.FragmentAppNavigationBinding

class FragmentNavigation : Fragment() {

    private var _binding: FragmentAppNavigationBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppNavigationBinding.inflate(inflater, container, false)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_navigation_app) as NavHostFragment
        val navController = navHostFragment.navController
        binding.buttonNavigation.setupWithNavController(navController)
        onButtonNavigationBarClicks(navController)
        return binding.root
    }

    private fun onButtonNavigationBarClicks(navController: NavController) {
        binding.buttonNavigation.setOnItemSelectedListener { item ->
            navController.navigate(item.itemId)
            true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}