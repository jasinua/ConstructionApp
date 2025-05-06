package com.example.collection.toolRegistration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.collection.R
import com.example.collection.databinding.FragmentEditBinding
import com.example.collection.model.Tool
import com.example.collection.viewModel.ToolViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class EditFragment : Fragment() {
private val args by navArgs<EditFragmentArgs>()


    //View Model
    val mToolViewModel:ToolViewModel by viewModels()
    //Binding
    private val binding: FragmentEditBinding by viewBinding(FragmentEditBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // putting the text in the Edit Text
        binding.toolUpdateName.setText(args.currentTool.toolName)
        binding.toolUpdateModule.setText(args.currentTool.toolModule)
        binding.toolUpdateYear.setText(args.currentTool.toolYear)
        binding.toolUpdateDescription.setText(args.currentTool.toolDescription)

        // when the button is clicked, it updates the tools
        binding.updateButton.setOnClickListener {
           updateTool()
        }

    }

    // update tool fuction
    private  fun updateTool() {

        //it gets the text from the EditText and converts it into a string
        val toolName = binding.toolUpdateName.text.toString()
        val toolModule = binding.toolUpdateModule.text.toString()
        val toolYear = binding.toolUpdateYear.text.toString()
        val toolDescription = binding.toolUpdateDescription.text.toString()


        // we have a function called inputCheck where it check if the EditTexts are empty
        if (inputCheck(toolName, toolModule, toolYear, toolDescription)) {

            //Create Tool Object
            val updatedTool = Tool(args.currentTool.id,toolName, toolModule, toolYear, toolDescription)

            //Update Current Tool
            mToolViewModel.updateTool(updatedTool)

            Toast.makeText(requireContext(), "Successfully Updated", Toast.LENGTH_LONG).show()

            //Navigating back
            findNavController().navigate(R.id.action_editFragment_to_viewFragment)

        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()

        }

    }


    private fun inputCheck (toolName: String, toolModule: String, toolYear: String, toolDescription:String): Boolean {
        return !(TextUtils.isEmpty(toolName) && TextUtils.isEmpty(toolModule) && TextUtils.isEmpty(toolYear) && TextUtils.isEmpty(toolDescription) )
    }
}


