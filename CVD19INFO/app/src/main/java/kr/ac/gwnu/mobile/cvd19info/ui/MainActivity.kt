package kr.ac.gwnu.mobile.cvd19info.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R
import kr.ac.gwnu.mobile.cvd19info.util.NonSymptomDecorator
import kr.ac.gwnu.mobile.cvd19info.util.SymptomDecorator


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setNavigationItemSelectedListener(this) //navigation 리스너
        nav_view.setItemIconTintList(null)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        calendarView.setOnDateChangedListener { _, date, _ ->
            btn1.setOnClickListener {
                calendarView.addDecorators(SymptomDecorator(this, date))
            }
            btn2.setOnClickListener {
                calendarView.addDecorators(NonSymptomDecorator(this, date))
            }
            btn3.setOnClickListener {
                calendarView.removeDecorators()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{ // 메뉴 버튼아니면
                main_drawer_layout.openDrawer(GravityCompat.START)    // 네비게이션 드로어 열기
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.my_page_item -> startActivity(Intent(this, MypageActivity::class.java))
            R.id.symptom_info_item -> startActivity(Intent(this, SymptomInfoActivity::class.java))
            R.id.symptom_chart_item -> startActivity(Intent(this, SymptomChartActivity::class.java))
            R.id.after_effect_info_item -> startActivity(Intent(this, AfterEffectInfoActivity::class.java))
            R.id.after_effect_chart_item -> startActivity(Intent(this, AfterEffectChartActivity::class.java))
        }
        return false
    }

    override fun onBackPressed() { //뒤로가기 처리
        if(main_drawer_layout.isDrawerOpen(GravityCompat.START)){
            main_drawer_layout.closeDrawers()
        } else{
            super.onBackPressed()
        }
    }
}