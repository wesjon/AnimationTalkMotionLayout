package br.com.wesjon

import androidx.recyclerview.widget.DiffUtil

enum class AnimationSample(
    val title: String,
    val description: String
) {

    CLASSICAL_OBJECT_ANIMATOR(
        "Classic: ObjectAnimator",
        "In"
    );

    companion object {
        val DIFF_UTIL_CALLBACK: DiffUtil.ItemCallback<AnimationSample> =
            object : DiffUtil.ItemCallback<AnimationSample>() {
                override fun areItemsTheSame(oldItem: AnimationSample, newItem: AnimationSample) =
                    oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: AnimationSample,
                    newItem: AnimationSample
                ) = true
            }
    }
}