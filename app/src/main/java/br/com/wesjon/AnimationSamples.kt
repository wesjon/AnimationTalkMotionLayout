package br.com.wesjon

import androidx.recyclerview.widget.DiffUtil
import br.com.wesjon.animations.ClassicObjectAnimatorFragment
import br.com.wesjon.animations.ClassicValueAnimatorFragment
import br.com.wesjon.animations.ClassicViewPropertyAnimationFragment
import br.com.wesjon.animations.MotionLayoutFabAnimation

enum class AnimationSamples(
    val title: String,
    val description: String
) {
    CLASSICAL_OBJECT_ANIMATOR(
        "Classic: ObjectAnimator",
        "Api classica para animar propriedades do Android"
    ),

    CLASSICAL_VALUE_ANIMATOR(
        "Classic: ValueAnimator",
        "Api classica que anima valores passando por todos os valores passados como parâmetro"
    ),

    CLASSICAL_VIEW_PROPERTY_ANIMATION(
        "Clasic: ViewPropertyAnimation",
        "Api que permite animar propriedades de views sem usar reflection"
    ),

    GROWING_SQUARE_MOTION_LAYOUT(
        "MotionLayout: Playground",
        "-"
    );

    fun getFragmentForAnimation() = when (this) {
        CLASSICAL_OBJECT_ANIMATOR -> ClassicObjectAnimatorFragment()
        CLASSICAL_VALUE_ANIMATOR -> ClassicValueAnimatorFragment()
        CLASSICAL_VIEW_PROPERTY_ANIMATION -> ClassicViewPropertyAnimationFragment()
        GROWING_SQUARE_MOTION_LAYOUT -> MotionLayoutFabAnimation()
    }

    companion object {
        val DIFF_UTIL_CALLBACK: DiffUtil.ItemCallback<AnimationSamples> =
            object : DiffUtil.ItemCallback<AnimationSamples>() {
                override fun areItemsTheSame(oldItem: AnimationSamples, newItem: AnimationSamples) =
                    oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: AnimationSamples,
                    newItem: AnimationSamples
                ) = true
            }
    }
}