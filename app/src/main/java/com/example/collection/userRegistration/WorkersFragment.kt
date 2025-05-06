package com.example.collection.userRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.collection.R
import com.example.collection.databinding.FragmentWorkersBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class WorkersFragment : Fragment(R.layout.fragment_workers) {


    private val binding: FragmentWorkersBinding by viewBinding(FragmentWorkersBinding::bind)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerUsersFragment.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_workersFragment_to_userRegisterFragment)
        }
        binding.viewUsersFragment.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_workersFragment_to_userViewFragment)
        }
    }
}