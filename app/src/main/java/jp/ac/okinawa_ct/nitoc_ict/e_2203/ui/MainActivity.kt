package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish
import jp.ac.okinawa_ct.nitoc_ict.e_2203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { //MainActivityクラス
    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) { //アプリ起動時の処理
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        //テスト用↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        val dummyDishList = listOf(
            Dish("ハンバーグ", "https://www.google.com", "https://cookpad.com"),
            Dish("カレーライス", "https://www.google.com", "https://cookpad.com"),
            Dish("チャーハン", "https://www.google.com", "https://cookpad.com"),
            Dish("ラーメン", "https://www.google.com", "https://cookpad.com"),
            Dish("ビーフシチュー", "https://www.google.com", "https://cookpad.com"),
            Dish("青椒肉絲", "https://www.google.com", "https://cookpad.com"),
        )

        setItemRoot(
            binding.item1Text,
            binding.item1Button1,
            binding.item1Button2,
            dummyDishList[0]
        )

        //テスト用↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


    }

    //こ↑こ↓から書くーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー


    //Dishのメンバ（String）とViewの参照（インスタンス）を受け取り、反映させる関数2つ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    fun setItemText(myTextView: TextView, name: String) { //Item*_text用
        myTextView.text = name
    }

    fun setItemButton(myButton: Button, mapURL: String) { //Item*_button1とItem*_button2用
        myButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(mapURL)
            startActivity(intent)
            //サーバーへのフィードバックはこ↑こ↓から呼び出せば良いのでは？
        }
    }

    //Dishのメンバ（String）とViewの参照（インスタンス）を受け取り、反映させる関数2つ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


    //Dish型と、複数のインスタンスを受け取って、上の各表示関数に渡す関数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    fun setItemRoot(myText: TextView, myButtonLeft: Button, myButtonRight: Button, myDish: Dish) {
        setItemText(myText, myDish.name)
        setItemButton(myButtonLeft, myDish.mapUrl)
        setItemButton(myButtonRight, myDish.recipeUrl)
    }

    //Dish型と、複数のインスタンスを受け取って、上の各表示関数に渡す関数↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


}

//コピペ用米↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑