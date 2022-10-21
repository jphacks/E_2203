package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R

class RecyclerAdapter :RecyclerView.Adapter<ViewHolderItem>(){

    private val animalList = listOf("ＴＤＮ", "ＴＮＯＫ", "ＨＴＮ")

    //こ↑こ↓で一行分のViewを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.itemName.text = animalList[position]

    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}