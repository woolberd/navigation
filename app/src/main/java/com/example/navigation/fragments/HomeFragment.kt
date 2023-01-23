package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnCat?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_catFragment)
        }
        binding?.btnCinema?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cinemaFragment)
        }
        binding?.btnLanguages?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_languagesFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}