package br.com.wesjon.animations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import kotlinx.android.synthetic.main.fragment_view_property_animation.*

class ClassicViewPropertyAnimationFragment : Fragment(R.layout.fragment_view_property_animation) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        square.animate()
            .setDuration(2000)
            .alpha(0.5f)
            .rotation(90f)
            .setStartDelay(1000)
            .start()
    }
}