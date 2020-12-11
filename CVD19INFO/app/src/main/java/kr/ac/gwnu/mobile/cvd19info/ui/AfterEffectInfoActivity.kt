package kr.ac.gwnu.mobile.cvd19info.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.after_effect_info_layout.*
import kotlinx.android.synthetic.main.symptom_info_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R

class AfterEffectInfoActivity : AppCompatActivity() {
    private var aeArray = arrayOf("탈모", "호흡 곤란", "기침", "후각소실", "미각 장애", "두통", "인후통", "근육통")
    private var pngArray = arrayOf(R.drawable.hairloss, R.drawable.cough, R.drawable.cough, R.drawable.smell, R.drawable.taste, R.drawable.head,
        R.drawable.sore, R.drawable.muscle)
    private var infoArray = arrayOf("탈모\n\n한 의과대학 기관에서는 코로나19에 감염됐다가 완치된 1천 567명을 상대로 실시한 설문조사에서, 응답자 중 423명(26.9%)이 코로나19 완치 후 탈모 증상을 경험했다고 답했습니다.",
        "호흡 곤란\n\n숨이 가쁘고 호흡이 힘들며, 가슴에 통증이 생길 수 있습니다.\n또한 맥박이 빨리 뛰고, 피부가 차가워지며, 축축한 느낌이 들 수 있고 숨을 쉴 때 거친 소리가 납니다.",
        "기침\n\n기침은 폐 속의 공기를 기도로 내뿜는 우리 몸의 방어 작용으로 기도 공간 확보와 이물질 배출을 위한 것입니다.\n코로나 감염 시 나타나는 기침의 특징은 발열, 인후통과 함께 마른 기침을 한다는 점입니다.",
        "후각소실\n\n후각소실은 말그대로 냄새를 맡지 못하게 되는 것입니다.\n대구 코로나 감염자 중 12.1%가 후각을 잃은 사례가 있습니다.",
        "미각 장애\n\n미각 장애는 맛을 느끼는 감각을 상실하는 것입니다.\n대구 코로나 감염자 중 11.1%가 미각을 잃은 사례가 있습니다.",
        "두통\n\n두통은 이마에서부터 관자놀이, 후두부, 뒷목 등을 포함하는 부위에 통증이 발생하는 것을 말합니다.\n두통은 사실상 모든 사람들이 일생 동안 한두 번 이상은 경험하는 증상입니다.",
        "인후통\n\n인후통 증상으로는 목감기 처럼 평소에 침을 삼킬 때에도 목이 아프거나 음식물을 삼킬 때도 아프고 발열이 있으며 두통이나 구토 등의 증상도 유발하게 됩니다.",
        "근육통\n\n근육통이란 근육부위에 생기는 통증을 의미하며, 다양한 질병이나 장애에서 나타날 수 있는 하나의 증상입니다.\n감염성 질환을 비롯한 수없이 많은 질환이나 장애에서도 근육통은 발생할 수 있습니다.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.after_effect_info_layout)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backspace_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        btnAEI.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("코로나 증상 종류를 선택하세요")
            builder.setItems(aeArray) { _, which ->
                imgAEI.setImageResource(pngArray[which])
                tvAEI.text = infoArray[which]
            }
            builder.setPositiveButton("닫기", null)
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