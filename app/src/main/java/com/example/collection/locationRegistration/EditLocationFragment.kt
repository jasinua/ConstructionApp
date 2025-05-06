package com.example.collection.locationRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.collection.R
import com.example.collection.databinding.FragmentEditLocationBinding
import com.example.collection.databinding.FragmentToolsBinding

class EditLocationFragment : Fragment() {

    private var _binding: FragmentEditLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentEditLocationBinding.inflate(inflater, container, false)
        return binding.root

    }

}