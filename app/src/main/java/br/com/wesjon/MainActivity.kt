package br.com.wesjon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

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




