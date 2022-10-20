package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        showList(dummyDishList)

        //setItemRoot(
        //    binding.item1Text,
        //    binding.item1Button1,
        //    binding.item1Button2,
        //    dummyDishList[0]
        //)

        /*setItemRoot(
            findViewById<TextView>(R.id.item1_text),
            findViewById<Button>(R.id.item1_button1),
            findViewById<Button>(R.id.item1_button2),
            dummyDishList[0]
        )*/

        //テスト用↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        val more_button = findViewById<Button>(R.id.more_button)
        more_button.setOnClickListener{
            more_button.text="今押しただろ、お前（半ギレ）" //クリックイベント確認用
            //画面変遷の処理を記述
        }


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


    //Dishのリストを受け取り、リスト全体に対してsetItemRootを処理する関数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    /*fun showList(dishList: List<Dish>) {
        setItemRoot( //1番目
            binding.item1Text,
            binding.item1Button1,
            binding.item1Button2,
            dishList[0]
        )
        setItemRoot( //2番目
            binding.item2Text,
            binding.item2Button1,
            binding.item2Button2,
            dishList[1]
        )
        setItemRoot( //3番目
            binding.item3Text,
            binding.item3Button1,
            binding.item3Button2,
            dishList[2]
        )
        setItemRoot( //4番目
            binding.item4Text,
            binding.item4Button1,
            binding.item4Button2,
            dishList[3]
        )
        setItemRoot( //5番目
            binding.item5Text,
            binding.item5Button1,
            binding.item5Button2,
            dishList[4]
        )
        setItemRoot( //6番目
            binding.item6Text,
            binding.item6Button1,
            binding.item6Button2,
            dishList[5]
        )
    }
    */
    fun showList(dishList: List<Dish>) {
        setItemRoot(
            findViewById<TextView>(R.id.item1_text),
            findViewById<Button>(R.id.item1_button1),
            findViewById<Button>(R.id.item1_button2),
            dishList[0]
        )
        setItemRoot(
            findViewById<TextView>(R.id.item2_text),
            findViewById<Button>(R.id.item2_button1),
            findViewById<Button>(R.id.item2_button2),
            dishList[1]
        )
        setItemRoot(
            findViewById<TextView>(R.id.item3_text),
            findViewById<Button>(R.id.item3_button1),
            findViewById<Button>(R.id.item3_button2),
            dishList[2]
        )
        setItemRoot(
            findViewById<TextView>(R.id.item4_text),
            findViewById<Button>(R.id.item4_button1),
            findViewById<Button>(R.id.item4_button2),
            dishList[3]
        )
        setItemRoot(
            findViewById<TextView>(R.id.item5_text),
            findViewById<Button>(R.id.item5_button1),
            findViewById<Button>(R.id.item5_button2),
            dishList[4]
        )
        setItemRoot(
            findViewById<TextView>(R.id.item6_text),
            findViewById<Button>(R.id.item6_button1),
            findViewById<Button>(R.id.item6_button2),
            dishList[5]
        )
    }
    //Dishのリストを受け取り、リスト全体に対してsetItemRootを処理する関数↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

//コピペ用米↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑