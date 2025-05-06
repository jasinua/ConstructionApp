package com.example.collection.userRegistration

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collection.R
import com.example.collection.databinding.FragmentUserViewBinding
import com.example.collection.viewModel.UserViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class UserViewFragment : Fragment(R.layout.fragment_user_view){


    private val binding: FragmentUserViewBinding by viewBinding(FragmentUserViewBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mUserViewModel: UserViewModel by viewModels()



        //recyclerView
        val adapter = UserListAdapter()
        val recyclerView = binding!!.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //
        binding.recyclerView.setAdapter(adapter)
        // if the SearchView is empty it'll show all the results in the recyclerView
        //else it'll filter by the query of the searchView
        //how do i put that "filteredText" to filter the data :D
       mUserViewModel.results.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }


       binding.filterUsers.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {


            override fun onQueryTextSubmit(query: String?): Boolean {
                val filteredUsers = "%$query%"
                mUserViewModel.setQuery(filteredUsers)
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                val filteredUsers = "%$query%"
                mUserViewModel.setQuery(filteredUsers)
                return true
            }
        })
    }



}