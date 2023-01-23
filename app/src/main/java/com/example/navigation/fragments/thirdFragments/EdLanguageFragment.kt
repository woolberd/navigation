package com.example.navigation.fragments.thirdFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentEdCatBinding
import com.example.navigation.databinding.FragmentEdCinemaBinding
import com.example.navigation.databinding.FragmentEdLanguageBinding

class EdLanguageFragment : Fragment() {

    private var binding: FragmentEdLanguageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEdLanguageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        binding?.btnToTextFragmentLang?.setOnClickListener {
            val bundle1 = Bundle()
            bundle1.putString("cat2", binding?.searchEditFrameLang?.text.toString())
            findNavController().navigate(R.id.action_edCinemaFragment_to_cinemaFragment, bundle1)
        }
    }
}