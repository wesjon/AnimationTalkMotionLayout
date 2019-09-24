package br.com.wesjon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_animation_sample.view.*

class AnimationSampleAdapter(private val listener: AnimationSampleListener) :
    ListAdapter<AnimationSamples, AnimationSampleAdapter.ViewHolder>(AnimationSamples.DIFF_UTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_animation_sample,
                parent,
                false
            ),
            listener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        view: View,
        private val listener: AnimationSampleListener
    ) :
        RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener { v ->
                val viewTag = v.tag
                if (viewTag is AnimationSamples) {
                    listener.onClick(viewTag)
                }
            }
        }

        fun bind(animationSample: AnimationSamples) {
            itemView.tag = animationSample

            itemView.title.text = animationSample.title
            itemView.description.text = animationSample.description
        }
    }
}

interface AnimationSampleListener {
    fun onClick(animationSample: AnimationSamples)
}
