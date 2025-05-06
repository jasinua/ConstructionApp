package com.example.collection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.collection.databinding.FragmentMainBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      binding.toolsCardFragment.setOnClickListener {
          Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_toolsFragment)

      }

        binding.usersCardFragment.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_workersFragment)
        }
            }

}