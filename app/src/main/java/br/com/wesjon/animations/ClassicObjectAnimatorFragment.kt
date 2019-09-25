package br.com.wesjon.animations

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import kotlinx.android.synthetic.main.fragment_object_animator.*

class ClassicObjectAnimatorFragment : Fragment(R.layout.fragment_object_animator) {
    lateinit var objectAnimator: ObjectAnimator
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        objectAnimator = ObjectAnimator.ofFloat(square, "alpha", 0f, 1f).apply {
            duration = 2000
            startDelay = 1000

            addUpdateListener {
                current_alpha.text = "Alpha: ${String.format("%.2f", square.alpha)}"
            }

            start()
        }
    }

    override fun onStop() {
        super.onStop()

        objectAnimator.cancel()
    }
}