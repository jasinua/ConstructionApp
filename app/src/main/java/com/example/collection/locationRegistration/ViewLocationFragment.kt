package com.example.collection.locationRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.collection.databinding.FragmentViewLocationBinding

class ViewLocationFragment : Fragment() {

    private var _binding: FragmentViewLocationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewLocationBinding.inflate(inflater, container, false)
        return binding.root
    }


}