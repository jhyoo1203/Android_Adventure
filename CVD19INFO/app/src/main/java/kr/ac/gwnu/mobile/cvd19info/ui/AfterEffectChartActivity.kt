package kr.ac.gwnu.mobile.cvd19info.ui

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.after_effect_chart_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R

class AfterEffectChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.after_effect_chart_layout)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backspace_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        btnAEC.setOnClickListener {
            val dlg = AfterEffectDialog(this)
            dlg.show(supportFragmentManager, "AfterEffectDialog")
        }

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(PieEntry(53f, "피로"))
            add(PieEntry(43f, "호흡곤란"))
            add(PieEntry(27f, "관절통증"))
            add(PieEntry(22f, "가슴통증"))
        }

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.COLORFUL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "코로나 후유증 발생률"
            piechart.description = des
        }
        piechart.data = pieData
        piechart.animateXY(1000, 1000)
        piechart.invalidate()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> { // 메뉴 버튼
                super.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

