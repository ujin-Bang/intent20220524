package com.start.intent20220524

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        binding.btnDial.setOnClickListener {
//            안드로이드 전화화면으로 이동.

//            입력한 전화번호 저장
            val inputPhoneNum = binding.edtPhoneNum.text.toString()

//            제공할 정보 2가지. 1)어떤 화면을로 갈건가?(ACTION) / 2)세부정보(전화걸기 - 어디로 전화거는가?) - Uri
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)
        }

        binding.btnCall.setOnClickListener {
            val phoneNum = binding.edtPhoneNum.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        결과를 받아서 돌아오면 실행되는 함수.
        Log.d("메인화면","결과를 받아오면 무조건 실행")

//        구별해야 할 요소 1)어떤걸 가지러 다녀온건지? - requestCode 2) 확인을 누른건지 / 취소(빽버튼)를 누른건지 구별 3)첨부한 데이터
        Log.d("리퀘스트코드",requestCode.toString())

//        닉네임을 가지러 다녀온게 맞는가?
        if( requestCode == REQ_CODE_FOR_NICKNAME) {

//            확인이 누린게 맞는가?
            if(resultCode == RESULT_OK) {

//                담아준 결과용 Intent => data에 담겨 있다. => "nick"으로 이름붙인 String을 꺼내주자.
                val newNickname = data?.getStringExtra("nick")
                binding.txtNickname.text = newNickname

            }

        }
    }

}