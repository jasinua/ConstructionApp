package com.example.collection.userRegistration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.collection.R
import com.example.collection.databinding.FragmentRegisterBinding
import com.example.collection.databinding.FragmentUserRegisterBinding
import com.example.collection.model.Tool
import com.example.collection.model.User
import com.example.collection.viewModel.ToolViewModel
import com.example.collection.viewModel.UserViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class UserRegisterFragment : Fragment(R.layout.fragment_user_register) {

    private lateinit var mUserViewModel: UserViewModel

    private val binding: FragmentUserRegisterBinding by viewBinding(FragmentUserRegisterBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.insertButton.setOnClickListener{
            insertData()
        }
    }

    private fun insertData() {
        val firstName = binding.userName.text.toString()
        val lastName = binding.userLastName.text.toString()
        val birthday = binding.userBirthday.text.toString()
        val numberID = binding.userNumberID.text.toString()

        if (inputCheck(firstName, lastName, birthday, numberID)) {
            val user = User(0, firstName, lastName, birthday, numberID)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
        } else{

            Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck (firstName: String, lastName: String, birthday: String, numberID:String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(birthday) && TextUtils.isEmpty(numberID) )
    }

}