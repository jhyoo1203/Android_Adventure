package kr.ac.gwnu.clockrona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.after_effect.view.*

class Frag2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.after_effect, container, false)

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(PieEntry(18.5f, "Green"))
            add(PieEntry(26.7f, "Yellow"))
            add(PieEntry(24.0f, "Red"))
            add(PieEntry(30.8f, "Blue"))
        }

        val set: PieDataSet = PieDataSet(yValues, "Election Results")
        val pieData: PieData = PieData(set)
        view.piechart.data = pieData
        view.piechart.invalidate()

        return view
    }
}
