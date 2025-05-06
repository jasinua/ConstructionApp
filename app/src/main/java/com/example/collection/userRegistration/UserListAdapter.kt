package com.example.collection.userRegistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.collection.R
import com.example.collection.model.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.costum_user_list, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.itemView.findViewById<TextView>(R.id.userId).text  = currentUser.id.toString()
        holder.itemView.findViewById<TextView>(R.id.userName).text  = currentUser.userName
        holder.itemView.findViewById<TextView>(R.id.userLastName).text  = currentUser.userLastName
        holder.itemView.findViewById<TextView>(R.id.userBirthday).text  = currentUser.userBirthday
        holder.itemView.findViewById<TextView>(R.id.userNumberID).text  = currentUser.userID

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {

//            val action = UserViewFragmentDirections. tionUserViewFragmentToEditUserFragment(currentUser)
//            holder.itemView.findNavController().navigate(action)


        }

    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}