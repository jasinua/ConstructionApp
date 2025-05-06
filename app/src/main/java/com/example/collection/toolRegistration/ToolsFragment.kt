package com.example.collection.toolRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.collection.R
import com.example.collection.databinding.FragmentToolsBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class ToolsFragment : Fragment() {

    //Binding
    private val binding: FragmentToolsBinding by viewBinding(FragmentToolsBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //if we click this view it sends us to register some new Tools
        binding.registerToolsFragment.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_toolsFragment_to_registerFragment2)
        }
        //if we click this view it sends us to view all our tools, then we can update them if we wish
        binding.viewToolsFragment.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_toolsFragment_to_viewFragment)
        }

    }
}