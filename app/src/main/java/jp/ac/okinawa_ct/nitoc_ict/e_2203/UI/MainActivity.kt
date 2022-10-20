package jp.ac.okinawa_ct.nitoc_ict.e_2203.UI

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import jp.ac.okinawa_ct.nitoc_ict.e_2203.R
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish

class MainActivity : AppCompatActivity() { //MainActivityクラス

    override fun onCreate(savedInstanceState: Bundle?) { //アプリ起動時の処理
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //テスト用↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

        val testval1 = findViewById<TextView>(R.id.item1_text)
        val testval2 = findViewById<Button>(R.id.item1_button1)
        val testval3 = findViewById<Button>(R.id.item1_button2)
        val testval4_yjloc = "https://www.google.com/maps?client=firefox-b-d&q=%E6%9D%B1%E4%BA%AC%E9%83%BD%E4%B8%96%E7%94%B0%E8%B0%B7%E5%8C%BA%E5%8C%97%E6%B2%A2%EF%BC%93%E4%B8%81%E7%9B%AE%EF%BC%92%EF%BC%93%E2%88%92%EF%BC%91%EF%BC%94&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjUwrzAke76AhVQY94KHTWkDpUQ_AUoAXoECAIQAw"
        val testval5_ohagi = "https://cookpad.com/dining/recipes/2762072"
        val testval6_yjname = "野獣の照り焼き"
        val testval7_yjdish = Dish(testval6_yjname, testval5_ohagi, testval4_yjloc)

        setItemRoot(testval1, testval2, testval3, testval7_yjdish)

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

//コメント用コピペ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑