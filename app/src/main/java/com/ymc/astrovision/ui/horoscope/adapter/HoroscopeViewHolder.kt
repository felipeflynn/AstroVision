package com.ymc.astrovision.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.ymc.astrovision.databinding.ItemHoroscopeBinding
import com.ymc.astrovision.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, action = { onItemSelected(horoscopeInfo) })
        }
    }

    private fun startRotationAnimation(view: View, action: () -> Unit) {
        view.animate().apply {
            binding.parent.isEnabled = false
            duration = 300
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {
                action()
                binding.parent.isEnabled = true
            }
            start()
        }
    }
}