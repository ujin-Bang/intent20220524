package com.start.intent20220524

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.intent20220524.databinding.ActivityEditNicknameBinding

class EditNicknameActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditNicknameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_nickname)

//        1.입력된 닉네임 변수에 저장
        binding.btnOk.setOnClickListener {
            val inputNickname = binding.edtNickname.text.toString()

//        2.닉네임을 들고 가야함 => 담아줘야함 => Intent추가 활용
            val resultIntent = Intent() //왕복이고, 데이터를 담기 위한 목적만 있음 , 출발/도착지 명시 X

    //  실제 데이터 첨부, putExtra
            resultIntent.putExtra("nick",inputNickname)

//            최종 결과(백버튼이 아닌 확인버튼누름, 들고 돌아갈 데이터) 지정
            setResult(RESULT_OK, resultIntent)

//            실제 이전화면으로 복귀
            finish()
        }

    }
}