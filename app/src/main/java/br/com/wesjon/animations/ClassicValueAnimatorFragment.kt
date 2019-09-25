package br.com.wesjon.animations

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import kotlinx.android.synthetic.main.fragment_classic_value_animator.*

class ClassicValueAnimatorFragment : Fragment(R.layout.fragment_classic_value_animator) {
    private lateinit var valueAnimator: ValueAnimator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valueAnimator = ValueAnimator.ofInt(0, 100).apply {
            duration = 2000
            addUpdateListener { valueAnimator ->
                display.text = "${valueAnimator.animatedValue}"
            }

            start()
        }
    }

    override fun onStop() {
        super.onStop()

        valueAnimator.cancel()
    }
}