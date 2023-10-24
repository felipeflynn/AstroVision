package com.ymc.astrovision.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.ymc.astrovision.R
import com.ymc.astrovision.databinding.ActivityHoroscopeDetailBinding
import com.ymc.astrovision.domain.model.HoroscopeModel
import com.ymc.astrovision.domain.model.HoroscopeModel.Aquarius
import com.ymc.astrovision.domain.model.HoroscopeModel.Aries
import com.ymc.astrovision.domain.model.HoroscopeModel.Cancer
import com.ymc.astrovision.domain.model.HoroscopeModel.Capricorn
import com.ymc.astrovision.domain.model.HoroscopeModel.Gemini
import com.ymc.astrovision.domain.model.HoroscopeModel.Leo
import com.ymc.astrovision.domain.model.HoroscopeModel.Libra
import com.ymc.astrovision.domain.model.HoroscopeModel.Pisces
import com.ymc.astrovision.domain.model.HoroscopeModel.Sagittarius
import com.ymc.astrovision.domain.model.HoroscopeModel.Scorpio
import com.ymc.astrovision.domain.model.HoroscopeModel.Taurus
import com.ymc.astrovision.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope_detail)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                        HoroscopeDetailState.Loading -> loadingState()
                    }
                }
            }
        }
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.apply {
            pb.isVisible = false
            tvTitle.text = state.sign
            tvBody.text = state.prediction
        }
        setDetailImage(state.horoscopeModel)
    }

    private fun setDetailImage(horoscopeModel: HoroscopeModel) {
        val image = when (horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }
}
