package com.example.collection.locationRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.collection.R
import com.example.collection.databinding.FragmentRegisterLocationBinding
import com.example.collection.databinding.FragmentToolsBinding

class RegisterLocationFragment : Fragment() {

    private var _binding: FragmentRegisterLocationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterLocationBinding.inflate(inflater, container, false)
        return binding.root
    }


}