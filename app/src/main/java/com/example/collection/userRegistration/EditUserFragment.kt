package com.example.collection.userRegistration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.collection.R
import com.example.collection.databinding.FragmentEditUserBinding
import com.example.collection.model.User
import com.example.collection.viewModel.UserViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class EditUserFragment : Fragment(R.layout.fragment_edit_user) {

    private val args by navArgs<EditUserFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    private val binding: FragmentEditUserBinding by viewBinding(FragmentEditUserBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.userName.setText(args.currentUser.userName)
        binding.userLastName.setText(args.currentUser.userLastName)
        binding.userBirthday.setText(args.currentUser.userBirthday)
        binding.userNumberID.setText(args.currentUser.userID)


        binding.updateButton.setOnClickListener {
            updateUser()
        }

    }
    private  fun updateUser() {
        val userName = binding.userName.text.toString()
        val userLastName = binding.userLastName.text.toString()
        val userBirthday = binding.userBirthday.text.toString()
        val userNumberID = binding.userNumberID.text.toString()

        if (inputCheck(userName, userLastName, userBirthday, userNumberID)) {

            //Create Tool Object
            val updatedUser = User(args.currentUser.id,userName, userLastName, userBirthday, userNumberID)

            //Update Current Tool
            mUserViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(), "Successfully Updated", Toast.LENGTH_LONG).show()

            //Navigating back
            findNavController().navigate(R.id.action_editUserFragment_to_userViewFragment)

        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()

        }

    }


    private fun inputCheck (userName: String, userLastName: String, userBirthday: String, userNumberID:String): Boolean {
        return !(TextUtils.isEmpty(userName) && TextUtils.isEmpty(userLastName) && TextUtils.isEmpty(userBirthday) && TextUtils.isEmpty(userNumberID) )
    }

}