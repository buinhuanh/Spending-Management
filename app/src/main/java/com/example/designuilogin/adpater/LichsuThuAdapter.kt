package com.example.designuilogin.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.designuilogin.R
import com.example.designuilogin.employeeThu

class LichsuThuAdapter(private val dsThu :ArrayList<employeeThu>):RecyclerView.Adapter<LichsuThuAdapter.ViewHolder>() {
    private lateinit var Listener:onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener (clickListener: onItemClickListener){
        Listener=clickListener
    }
    class ViewHolder(itemView: View, clickListener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.layout_lichsu_item,parent,false)
        return ViewHolder(itemView,Listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val txtLichSu=findViewById<TextView>(R.id.txtLichSu)
            txtLichSu.text=dsThu[position].khoanThu
        }
    }

    override fun getItemCount(): Int {
        return dsThu.size
    }
}