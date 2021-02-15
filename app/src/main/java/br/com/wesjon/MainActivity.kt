package br.com.wesjon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.wesjon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUpExampleList()
    }

    private fun setupUpExampleList() {
        binding.sampleList.adapter = AnimationSampleAdapter(
            object : AnimationSampleListener {
                override fun onClick(animationSample: AnimationSamples) {
                    startActivity(AnimationCanvasActivity.getIntent(this@MainActivity, animationSample))
                }
            }
        ).apply {
            submitList(AnimationSamples.values().toList())
        }
        binding.sampleList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}




