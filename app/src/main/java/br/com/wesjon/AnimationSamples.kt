package br.com.wesjon

import androidx.recyclerview.widget.DiffUtil
import br.com.wesjon.animations.*

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
        "Classic: ViewPropertyAnimation",
        "Api que permite animar propriedades de views sem usar reflection"
    ),

    MOTION_LAYOUT_MOVING_SQUARE_ANIMATION(
        "MotionLayout: Moving square animation",
        "Faz uma translação do quadro do início ao fim da tela"
    ),

    MOTION_LAYOUT_DRAG_MOVE_SQUARE_ANIMATION(
        "MotionLayout: Drag square animation",
        "Animação iterativa para fazer drag de um quadrado na tela"
    ),

    MOTION_LAYOUT_FAB_ANIMATION_SAMPLE(
        "MotionLayout: Fab animation",
        "Exemplo usando a API MotionLayout para criar uma animação de fab"
    );

    fun getFragmentForAnimation() = when (this) {
        CLASSICAL_OBJECT_ANIMATOR -> ClassicObjectAnimatorFragment()
        CLASSICAL_VALUE_ANIMATOR -> ClassicValueAnimatorFragment()
        CLASSICAL_VIEW_PROPERTY_ANIMATION -> ClassicViewPropertyAnimationFragment()
        MOTION_LAYOUT_FAB_ANIMATION_SAMPLE -> MotionLayoutFabAnimationFragment()
        MOTION_LAYOUT_DRAG_MOVE_SQUARE_ANIMATION -> MotionLayoutDragAnimationFragment()
        MOTION_LAYOUT_MOVING_SQUARE_ANIMATION -> MotionLayoutMovingSquareAnimationFragment()
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