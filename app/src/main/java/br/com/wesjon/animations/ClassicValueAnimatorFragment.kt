package br.com.wesjon.animations

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import br.com.wesjon.databinding.FragmentClassicValueAnimatorBinding

class ClassicValueAnimatorFragment : Fragment(R.layout.fragment_classic_value_animator) {
    private lateinit var valueAnimator: ValueAnimator

    lateinit var binding: FragmentClassicValueAnimatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClassicValueAnimatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valueAnimator = ValueAnimator.ofInt(0, 100).apply {
            duration = 2000
            addUpdateListener { valueAnimator ->
                binding.display.text = "${valueAnimator.animatedValue}"
            }

            start()
        }
    }

    override fun onStop() {
        super.onStop()

        valueAnimator.cancel()
    }
}