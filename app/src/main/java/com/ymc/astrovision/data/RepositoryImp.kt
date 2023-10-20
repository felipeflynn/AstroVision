package com.ymc.astrovision.data

import android.util.Log
import com.ymc.astrovision.data.network.HoroscopeApiService
import com.ymc.astrovision.domain.Repository
import com.ymc.astrovision.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "Ha ocurrido un error ${it.message}") }
        return null
    }
}