package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish

class RecyclerAdapter(val myActivity: SubActivity, val dishList: List<Dish>) :RecyclerView.Adapter<ViewHolderItem>(){
    //private val dishList = listOf("ＴＤＮ", "ＴＮＯＫ", "ＨＴＮ", "ＤＢ", "ＴＤＫＲ", "ＭＵＲ", "ＧＯ", "ＮＳＯＫ", "ＭＮＴＮＹＮＩＮＭ", "ＤＲＶＳ", "ＳＢＲ", "ＭＲＳ", "ＯＴＫ", "ＫＭＯＴ", "ＹＪＳＮＰＩ", "ＫＭＲ", "ＴＯＮ", "ＩＮＭ", "ＲＩＭ", "ＹＭＮ", "ＫＢＴＩＴ")
    /*private val dishList = listOf(
        Dish("ハンバーグ", "https://www.google.com", "https://cookpad.com"),
        Dish("カレーライス", "https://www.google.com", "https://cookpad.com"),
        Dish("チャーハン", "https://www.google.com", "https://cookpad.com"),
        Dish("ラーメン", "https://www.google.com", "https://cookpad.com"),
        Dish("ビーフシチュー", "https://www.google.com", "https://cookpad.com"),
        Dish("青椒肉絲", "https://www.google.com", "https://cookpad.com"),
        Dish("ハンバーグ", "https://www.google.com", "https://cookpad.com"),
        Dish("カレーライス", "https://www.google.com", "https://cookpad.com"),
        Dish("チャーハン", "https://www.google.com", "https://cookpad.com"),
        Dish("ラーメン", "https://www.google.com", "https://cookpad.com"),
        Dish("ビーフシチュー", "https://www.google.com", "https://cookpad.com"),
        Dish("青椒肉絲", "https://www.google.com", "https://cookpad.com"),
    )
     */

    //こ↑こ↓で一行分のViewを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.itemName.text = dishList[position].name
        holder.itemButtonLeft.setOnClickListener {
            //val intent = Intent(Intent.ACTION_VIEW)
            //intent.data = Uri.parse(dishList[position].mapUrl)
            //startActivity(intent)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(dishList[position].mapUrl)
            myActivity.startActivity(intent)
            //サーバーへのフィードバックはこ↑こ↓から呼び出せば良いのでは？
        }
        holder.itemButtonRight.setOnClickListener {
            //val intent = Intent(Intent.ACTION_VIEW)
            //intent.data = Uri.parse(dishList[position].mapUrl)
            //startActivity(intent)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(dishList[position].recipeUrl)
            myActivity.startActivity(intent)
            //サーバーへのフィードバックはこ↑こ↓から呼び出せば良いのでは？
        }
    }

    override fun getItemCount(): Int {
        return dishList.size
    }

}