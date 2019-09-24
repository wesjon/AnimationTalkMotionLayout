package br.com.wesjon.animations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.wesjon.R

class MotionLayoutFabAnimation : Fragment(R.layout.fragment_motion_layout_fab_animation) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                motion_layout.progress = progress / 100f
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//            }
//        })
    }
}