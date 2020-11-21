package kr.ac.gwnu.clockrona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 화면 구성
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, Frag1())
            .commit()

        // 하단바 동작
        chip_navigation.setOnItemSelectedListener { id ->
            when (id) {
                R.id.map -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, Frag1())
                    .commit()
                R.id.effect -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, Frag2())
                    .commit()
                R.id.alerts -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, Frag3())
                    .commit()
            }
        }

        //DB추가
        addAfterEffectDB()
    }

    fun addAfterEffectDB() {
        //DB추가
        db = DBHelper(this)
        db.addAfterEffect(1, "피로", 53)
        db.addAfterEffect(2, "호흡곤란", 43)
        db.addAfterEffect(3, "미각장애", 41)
        db.addAfterEffect(4, "관절통증", 27)
        db.addAfterEffect(5, "근육통", 27)
        db.addAfterEffect(6, "혈전", 25)
        db.addAfterEffect(7, "탈모", 25)
        db.addAfterEffect(8, "흉통", 22)
        db.addAfterEffect(9, "기침", 16)
        db.addAfterEffect(10, "후각소실", 15)
        db.addAfterEffect(11, "건조증후근", 13)
        db.addAfterEffect(12, "비염", 12)
        db.addAfterEffect(13, "적목현상", 10)
        db.addAfterEffect(14, "두통", 9)
        db.addAfterEffect(15, "가래", 7)
        db.addAfterEffect(16, "식욕저하", 7)
        db.addAfterEffect(17, "인후통", 6)
        db.addAfterEffect(18, "어지럼증", 4)
        db.addAfterEffect(19, "설사", 2)
    }
}
