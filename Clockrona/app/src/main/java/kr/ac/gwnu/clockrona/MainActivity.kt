package kr.ac.gwnu.clockrona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}
