package com.start.intent20220524

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.intent20220524.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val REQ_CODE_FOR_NICKNAME = 1000

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnMoveToOther.setOnClickListener {
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }

        binding.btnSendToMessage.setOnClickListener {
            val inputMessage = binding.edtMessage.text.toString()

            val myIntent = Intent(this, ViewMessageActivity::class.java)

            myIntent.putExtra("message",inputMessage)
            startActivity(myIntent)

        }

        binding.btnChangeNickname.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQ_CODE_FOR_NICKNAME)
        }
    }
}