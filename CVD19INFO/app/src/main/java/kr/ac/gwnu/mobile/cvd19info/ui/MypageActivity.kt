package kr.ac.gwnu.mobile.cvd19info.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.mypage_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R
import kr.ac.gwnu.mobile.cvd19info.model.ContentDTO

class MypageActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_layout)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backspace_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        auth = FirebaseAuth.getInstance()

        var contentDTO = ContentDTO()
        contentDTO.userid = auth?.currentUser?.email

        user_id.text = contentDTO.userid

        logout_btn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{ // 메뉴 버튼
                super.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}