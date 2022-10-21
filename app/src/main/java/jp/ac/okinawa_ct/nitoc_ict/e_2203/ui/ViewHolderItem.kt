package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R

class ViewHolderItem(itemView:View) :RecyclerView.ViewHolder(itemView){
    val itemName: TextView = itemView.findViewById(R.id.tv) //料理名
    val itemButtonLeft: Button = itemView.findViewById(R.id.button_1) //GoogleMapへ飛ぶボタン
    val itemButtonRight: Button = itemView.findViewById(R.id.button_2) //cookpadへ飛ぶボタン
}