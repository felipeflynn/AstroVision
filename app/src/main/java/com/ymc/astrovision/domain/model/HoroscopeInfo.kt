package com.ymc.astrovision.domain.model

import com.ymc.astrovision.R

sealed class HoroscopeInfo(val img: Int, val name: Int) {
    object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries)
    object Taurus : HoroscopeInfo(R.drawable.taurus, R.string.taurus)
    object Gemini : HoroscopeInfo(R.drawable.gemini, R.string.gemini)
    object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    object Leo : HoroscopeInfo(R.drawable.leo, R.string.leo)
    object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.virgo)
    object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    object Scorpio : HoroscopeInfo(R.drawable.scorpio, R.string.scorpio)
    object Sagittarius : HoroscopeInfo(R.drawable.sagittarius, R.string.sagittarius)
    object Capricorn : HoroscopeInfo(R.drawable.capricorn, R.string.capricorn)
    object Aquarius : HoroscopeInfo(R.drawable.aquarius, R.string.aquarius)
    object Pisces : HoroscopeInfo(R.drawable.pisces, R.string.pisces)
}
