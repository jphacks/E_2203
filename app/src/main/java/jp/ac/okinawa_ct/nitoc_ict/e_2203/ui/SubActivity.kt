package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

//import android.content.Intent
//import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Button
//import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish

class SubActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        //テスト用（本来ならdishListに本物データを入れる）↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        val dishList = listOf(
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
        //テスト用（本来ならdishListに本物データを入れる）↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        recyclerView = findViewById(R.id.rv)
        recyclerView.adapter = RecyclerAdapter(this, dishList)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}

//コピペ用米↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑