package com.start.intent20220524

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.intent20220524.databinding.ActivityViewMessageBinding

class ViewMessageActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_view_message)

        val changeMessage = intent.getStringExtra("message")
        binding.txtInputMessage.text = changeMessage
    }
}