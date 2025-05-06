package com.example.collection.toolRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collection.R
import com.example.collection.databinding.FragmentRegisterBinding
import com.example.collection.viewModel.ToolViewModel
import com.example.collection.databinding.FragmentViewBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class ViewFragment : Fragment(R.layout.fragment_view) {

    private lateinit var mToolViewModel: ToolViewModel

    private val binding: FragmentViewBinding by viewBinding(FragmentViewBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //UserViewModel

        mToolViewModel = ViewModelProvider(this).get(ToolViewModel::class.java)
        mToolViewModel.readAllData.observe(viewLifecycleOwner , Observer { user ->
            adapter.setData(user)
        })


    }
}