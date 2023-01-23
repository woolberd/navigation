package com.example.navigation.fragments.detailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.navigation.R
import com.example.navigation.databinding.FragmentDetalilCinemaBinding
import com.example.navigation.model.HomeModel

class DetailCinemaFragment : Fragment() {

    private lateinit var binding: FragmentDetalilCinemaBinding
    private var model: HomeModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalilCinemaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data
        click()
    }

    private fun click() {
        binding.closeCinema.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val data: Unit
        get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable("key") as HomeModel
                binding.imageDetail.let {
                    it.context.let { it1 ->
                        Glide.with(it1).load(model?.image).into(binding.imageDetail)
                    }
                }
                binding.txtNameDetail.text = model?.name
            }
        }
}