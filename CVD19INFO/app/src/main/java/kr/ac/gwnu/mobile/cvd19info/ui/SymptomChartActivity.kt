package kr.ac.gwnu.mobile.cvd19info.ui

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.after_effect_chart_layout.piechart
import kotlinx.android.synthetic.main.symptom_chart_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R

class SymptomChartActivity : AppCompatActivity() {
    private var symArray = arrayOf("발열", "마른 기침", "피로", "가래", "호흡곤란", "인후통", "두통", "근육통",
        "오한", "메스꺼움", "코 충혈", "설사", "객혈", "결막 충혈")
    private var icArray = arrayOf("87.9", "67.7", "38.1", "33.4", "18.6", "13.9", "13.6", "14.8", "11.4", "5.0", "4.8", "3.7", "0.9", "0.8")
    private var selectItems = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.symptom_chart_layout)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backspace_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        btnSC.setOnClickListener {
            selectItems.clear()
            var builder = AlertDialog.Builder(this)
            builder.setTitle("코로나 증상 종류를 선택하세요")
            builder.setMultiChoiceItems(
                symArray,
                null,
                object : DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        if (isChecked) {
                            selectItems.add(which)
                        } else if (selectItems.contains(which)) {
                            selectItems.remove(which)
                        }
                    }
                })

            var listener = DialogInterface.OnClickListener { _, _ ->
                val yValues: ArrayList<PieEntry> = ArrayList()
                with(yValues) {
                    for(i in 0 until selectItems.size) {
                        add(PieEntry(icArray[selectItems[i]].toFloat(), symArray[selectItems[i]]))
                    }
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
                    des.text = "코로나 증상 발생률"
                    piechart.description = des
                }
                piechart.data = pieData
                piechart.animateXY(1000, 1000)
                piechart.invalidate()
            }
            builder.setPositiveButton("완료", listener)
            builder.show()
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