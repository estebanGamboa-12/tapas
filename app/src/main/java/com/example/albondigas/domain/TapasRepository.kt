package com.example.albondigas.domain

import com.example.albondigas.app.Either
import com.example.albondigas.app.ErrorApp

interface TapasRepository {
    fun obtainTapas():Either<ErrorApp,Tapas>
}