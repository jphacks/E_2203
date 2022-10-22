package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish

class RecyclerAdapter(val myActivity: SubActivity, val dishList: List<Dish>) :RecyclerView.Adapter<ViewHolderItem>(){

    //ここで一行分のViewを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.itemName.text = dishList[position].name
        holder.itemButtonLeft.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(dishList[position].mapUrl)
            myActivity.startActivity(intent)
            // [記述.4] サーバーへのフィードバック呼び出し------ **
        }
        holder.itemButtonRight.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(dishList[position].recipeUrl)
            myActivity.startActivity(intent)
            // [記述.5] サーバーへのフィードバック呼び出し------ **
        }
    }

    override fun getItemCount(): Int {
        return dishList.size
    }

}