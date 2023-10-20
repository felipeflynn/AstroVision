package com.ymc.astrovision.domain

import com.ymc.astrovision.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}