package kr.ac.gwnu.mobile.cvd19info.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.symptom_info_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import kr.ac.gwnu.mobile.cvd19info.R

class SymptomInfoActivity : AppCompatActivity() {
    private var symArray = arrayOf("발열", "마른 기침", "피로", "인후통", "두통", "근육통", "메스꺼움", "설사")
    private var pngArray = arrayOf(R.drawable.fever, R.drawable.cough, R.drawable.fatigue, R.drawable.sore, R.drawable.head, R.drawable.muscle,
        R.drawable.nausea, R.drawable.diarrhea)
    private var infoArray = arrayOf("발열\n\n대체로 37.5도 이상의 고열이 나타납니다.\n가장 먼저 나타나는 코로나 증상이 열이 나는 것이므로 체온 측정을 통해 초기 진단, 격리, 치료를 앞당길 수 있습니다.",
        "마른 기침\n\n기침은 폐 속의 공기를 기도로 내뿜는 우리 몸의 방어 작용으로 기도 공간 확보와 이물질 배출을 위한 것입니다.\n코로나 감염 시 나타나는 기침의 특징은 발열, 인후통과 함께 마른 기침을 한다는 점입니다.",
        "피로\n\n과로, 질병, 사건사고, 에너지 소모 등 여러가지 요인으로 인해 몸 혹은 정신이 지치고 힘든 상태입니다.\n가벼운 육체적, 정신적 피로는 충분한 휴식으로 해소할 수 있으나, 지속적인 피로 누적은 상상이상으로 건강에 안좋습니다.",
        "인후통\n\n인후통 증상으로는 목감기 처럼 평소에 침을 삼킬 때에도 목이 아프거나 음식물을 삼킬 때도 아프고 발열이 있으며 두통이나 구토 등의 증상도 유발하게 됩니다.",
        "두통\n\n두통은 이마에서부터 관자놀이, 후두부, 뒷목 등을 포함하는 부위에 통증이 발생하는 것을 말합니다. 두통은 사실상 모든 사람들이 일생 동안 한두 번 이상은 경험하는 증상입니다.",
        "근육통\n\n근육통이란 근육부위에 생기는 통증을 의미하며, 다양한 질병이나 장애에서 나타날 수 있는 하나의 증상입니다.\n감염성 질환을 비롯한 수없이 많은 질환이나 장애에서도 근육통은 발생할 수 있습니다.",
        "메스꺼움\n\n메스꺼움이란 신체가 불편함을 느껴서 토할 것 같은 불쾌감을 말하는데, 욕지기라고도 합니다. 목이나 앞가슴에서 느끼는 메스꺼움은 구토로 연결될 수도 있고, 그 단계에 그냥 머물 수도 있습니다.",
        "설사\n\n설사는 변이 무르고 물기가 많은 상태로 배설되는 상태입니다. 이러한 설사는 기능성 소화기 질환 및 다양한 소화기 질환과 동반될 수 있으나, 그 자체가 여러 가지 이유로 인해 급성 또는 만성으로 일어날 수도 있습니다.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.symptom_info_layout)

        setSupportActionBar(my_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backspace_white) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        btnSI.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("코로나 증상 종류를 선택하세요")
            builder.setItems(symArray) { _, which ->
                imgSI.setImageResource(pngArray[which])
                tvSI.text = infoArray[which]
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