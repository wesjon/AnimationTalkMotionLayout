package br.com.wesjon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class AnimationCanvasActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pickAnimation()
    }

    private fun pickAnimation() {
        val animationIndex = intent.getIntExtra(ANIMATION_INDEX_KEY, 0)
        replaceFragment(AnimationSamples.values()[animationIndex].getFragmentForAnimation())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .commit()
    }

    companion object {
        private const val ANIMATION_INDEX_KEY = "ANIMATION_INDEX_KEY"
        fun getIntent(context: Context, animationSample: AnimationSamples): Intent {
            return Intent(context, AnimationCanvasActivity::class.java).apply {
                putExtras(
                    bundleOf(ANIMATION_INDEX_KEY to AnimationSamples.valueOf(animationSample.name).ordinal)
                )
            }
        }
    }
}
