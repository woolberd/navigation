package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.`interface`.OnClickItem
import com.example.navigation.adapter.CatAdapter
import com.example.navigation.adapter.LanguageAdapter
import com.example.navigation.databinding.FragmentCatBinding
import com.example.navigation.databinding.FragmentLanguagesBinding
import com.example.navigation.model.HomeModel
import com.example.navigation.repository.CatRepository
import com.example.navigation.repository.LanguageRepository

class LanguagesFragment : Fragment(), OnClickItem {

    private var binding: FragmentLanguagesBinding? = null
    private val textList = ArrayList<HomeModel>()
    private val adapter = LanguageAdapter(textList, this)
    private val repo = LanguageRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguagesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        click()
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(HomeModel("", text.toString()))
        }
    }

    private fun click() {
        binding?.btnToThirdFragLang?.setOnClickListener {
            findNavController().navigate(R.id.action_languagesFragment_to_edLanguageFragment)
        }
    }

    private fun initialize() {
        binding?.rvLanguage?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfLanguage())
        binding?.rvLanguage?.adapter = adapter
    }

    override fun onClick(model: HomeModel) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        findNavController().navigate(
            R.id.action_languagesFragment_to_detailLanguageFragment,
            bundle
        )
            .toString()
    }

    override fun onLongClick(model: HomeModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}