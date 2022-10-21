package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R

class ViewHolderItem(itemView:View) :RecyclerView.ViewHolder(itemView){
    val itemName: TextView = itemView.findViewById(R.id.tv)
}