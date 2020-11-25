package kr.ac.gwnu.mobile.cvd19info

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AfterEffectDialog(context: Context): DialogFragment() {
    private val contextdlg = context

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var aeArray = arrayOf("피로", "호흡곤란", "관절통증") //후유증 추가
        var selectedArray = ArrayList<Int>() //체크박스 체크 넣을 것
        val dlg: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(
            contextdlg,  android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        dlg.setTitle("코로나 후유증 종류를 선택하세요")
            //dlg.setIcon() //제목 옆 아이콘 설정
            // Specify the list array, the items to be selected by default (null for none),
            // and the listener through which to receive callbacks when items are selected
            .setMultiChoiceItems(aeArray, null,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    if (isChecked) {
                        selectedArray.add(which)
                    } else if (selectedArray.contains(which)) {
                        selectedArray.remove(Integer.valueOf(which))
                    } //선택한 항목 selectedArray에 저장
                })

            .setPositiveButton("완료",
                DialogInterface.OnClickListener { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                    //완료 누르면 파이 차트에 나올 수 있게
                })
        val return_dlg = dlg.create()
        return return_dlg
    }
}
