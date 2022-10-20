package jp.ac.okinawa_ct.nitoc_ict.e_2203.ui

import android.widget.Button
import android.widget.TextView

/**
 * リストの一要素を表現するクラス
 *
 * @property myText     料理名用のTextView
 * @property myButton1  左のボタン
 * @property myButton2  右のボタン
 */
data class ListElementInstances(
    val myText: TextView,
    val myButton1: Button,
    val myButton2: Button,
)
