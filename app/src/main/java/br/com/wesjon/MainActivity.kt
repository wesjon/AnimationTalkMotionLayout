package br.com.wesjon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

val apiDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
val completeDateFormat = SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale("pt_BR"))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val parsedDate = apiDateFormat.parse("2019-12-11T18:08:39Z")
        dateTest.text =completeDateFormat.format(parsedDate)

        setupUpExampleList()
    }

    private fun setupUpExampleList() {
        sample_list.adapter = AnimationSampleAdapter(
            object : AnimationSampleListener {
                override fun onClick(animationSample: AnimationSamples) {
                    startActivity(AnimationCanvasActivity.getIntent(this@MainActivity, animationSample))
                }
            }
        ).apply {
            submitList(AnimationSamples.values().toList())
        }
        sample_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}




