package com.example.collection.toolRegistration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.collection.R
import com.example.collection.model.Tool
import com.example.collection.viewModel.ToolViewModel
import com.example.collection.databinding.FragmentRegisterBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var mToolViewModel: ToolViewModel

    private val binding:FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mToolViewModel = ViewModelProvider(this).get(ToolViewModel::class.java)

        binding.insertButton.setOnClickListener{
            insertData()
        }
    }

    private fun insertData() {
        val toolName = binding.toolName.text.toString()
        val toolModule = binding.toolModule.text.toString()
        val toolYear = binding.toolYear.text.toString()
        val toolDescription = binding.toolDescription.text.toString()

        if (inputCheck(toolName, toolModule, toolYear, toolDescription)) {
            val tool = Tool(0, toolName, toolModule, toolYear, toolDescription)
            mToolViewModel.addTool(tool)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
        } else{

            Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck (toolName: String, toolModule: String, toolYear: String, toolDescription:String): Boolean {
        return !(TextUtils.isEmpty(toolName) && TextUtils.isEmpty(toolModule) && TextUtils.isEmpty(toolYear) && TextUtils.isEmpty(toolDescription) )
    }
}