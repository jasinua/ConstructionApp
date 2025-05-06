package com.example.collection.toolRegistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.collection.R
import com.example.collection.model.Tool

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var toolList = emptyList<Tool>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.costum_list, parent, false))
    }

    override fun getItemCount(): Int {
        return toolList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = toolList[position]
        holder.itemView.findViewById<TextView>(R.id.toolID).text  = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.toolName).text  = currentItem.toolName
        holder.itemView.findViewById<TextView>(R.id.toolModule).text  = currentItem.toolModule
        holder.itemView.findViewById<TextView>(R.id.toolYear).text  = currentItem.toolYear
        holder.itemView.findViewById<TextView>(R.id.toolDescription).text  = currentItem.toolDescription

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {

            val action = ViewFragmentDirections.actionViewFragmentToEditFragment(currentItem)
            holder.itemView.findNavController().navigate(action)


        }

    }

    fun setData(tool: List<Tool>) {
        this.toolList = tool
        notifyDataSetChanged()
    }
}