package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.`interface`.OnClickItem
import com.example.navigation.adapter.CatAdapter
import com.example.navigation.databinding.FragmentCatBinding
import com.example.navigation.model.HomeModel
import com.example.navigation.repository.CatRepository
import java.io.Serializable

class CatFragment : Fragment(), OnClickItem {

    private var binding: FragmentCatBinding? = null
    private val textList = ArrayList<HomeModel>()
    private val adapter = CatAdapter(textList, this)
    private val repo = CatRepository()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        click()
        getData()
    }

    private fun click() {
        binding?.btnToThirdFragCat?.setOnClickListener {
            findNavController().navigate(R.id.action_catFragment_to_edCatFragment)
        }
    }

    private fun initialize() {
        binding?.rvCat?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfCat())
        binding?.rvCat?.adapter = adapter
    }

    override fun onClick(model: HomeModel) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        findNavController().navigate(R.id.action_catFragment_to_detailCatFragment, bundle)
            .toString()
    }

    override fun onLongClick(model: HomeModel): Boolean {
        TODO("Not yet implemented")
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(HomeModel("",text.toString()))
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}