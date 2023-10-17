package com.ymc.astrovision.data.providers

import com.ymc.astrovision.domain.model.HoroscopeInfo
import com.ymc.astrovision.domain.model.HoroscopeInfo.Aquarius
import com.ymc.astrovision.domain.model.HoroscopeInfo.Aries
import com.ymc.astrovision.domain.model.HoroscopeInfo.Cancer
import com.ymc.astrovision.domain.model.HoroscopeInfo.Capricorn
import com.ymc.astrovision.domain.model.HoroscopeInfo.Gemini
import com.ymc.astrovision.domain.model.HoroscopeInfo.Leo
import com.ymc.astrovision.domain.model.HoroscopeInfo.Libra
import com.ymc.astrovision.domain.model.HoroscopeInfo.Pisces
import com.ymc.astrovision.domain.model.HoroscopeInfo.Sagittarius
import com.ymc.astrovision.domain.model.HoroscopeInfo.Scorpio
import com.ymc.astrovision.domain.model.HoroscopeInfo.Taurus
import com.ymc.astrovision.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Gemini,
            Taurus,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}