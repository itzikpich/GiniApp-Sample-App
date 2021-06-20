package com.itzikpich.giniappssampleapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.itzikpich.giniappssampleapp.adapters.NumberAdapter
import com.itzikpich.giniappssampleapp.databinding.FragmentMainBinding
import com.itzikpich.giniappssampleapp.view_models.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment: Fragment() {

    lateinit var binding: FragmentMainBinding
    val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NumberAdapter()
        binding.mainAdapter.adapter = adapter

        viewModel.numberItemTypeList.observe(viewLifecycleOwner) { list ->
            adapter.setList(list)
        }

    }

}