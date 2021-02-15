package br.com.wesjon.animations

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import br.com.wesjon.databinding.FragmentObjectAnimatorBinding

class ClassicObjectAnimatorFragment : Fragment() {
    lateinit var objectAnimator: ObjectAnimator
    @SuppressLint("SetTextI18n")

    lateinit var binding: FragmentObjectAnimatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentObjectAnimatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        objectAnimator = ObjectAnimator.ofFloat(binding.square, "alpha", 0f, 1f).apply {
            duration = 2000
            startDelay = 1000

            addUpdateListener {
                binding.currentAlpha.text = "Alpha: ${String.format("%.2f", binding.square.alpha)}"
            }

            start()
        }
    }

    override fun onStop() {
        super.onStop()

        objectAnimator.cancel()
    }
}