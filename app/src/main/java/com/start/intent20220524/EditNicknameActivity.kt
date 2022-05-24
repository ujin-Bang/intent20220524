package com.start.intent20220524

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.intent20220524.databinding.ActivityEditNicknameBinding

class EditNicknameActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditNicknameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_nickname)



    }
}