package br.com.wesjon.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.wesjon.R
import br.com.wesjon.databinding.FragmentViewPropertyAnimationBinding

class ClassicViewPropertyAnimationFragment : Fragment(R.layout.fragment_view_property_animation) {
    lateinit var binding: FragmentViewPropertyAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPropertyAnimationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.square.animate()
            .setDuration(2000)
            .alpha(0.5f)
            .rotation(90f)
            .setStartDelay(1000)
            .start()
    }
}