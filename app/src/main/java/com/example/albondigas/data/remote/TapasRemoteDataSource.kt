package com.example.albondigas.data.remote

import com.example.albondigas.app.Either
import com.example.albondigas.app.ErrorApp
import com.example.albondigas.app.right
import com.example.albondigas.domain.Tapas

class TapasRemoteDataSource {

    fun getTapas():Either<ErrorApp,Tapas> =
        Tapas(
           "1",
            "1º",
            "https://dam.sitehub.es/curso-2023-2024/api/images/hotels-01.png",
            "albondigas",
            "vermuteria",
            "Total:3",
            "Media:2",
            "https://dam.sitehub.es/curso-2023-2024/api/images/hotels-01.png",
            "https://dam.sitehub.es/curso-2023-2024/api/images/hotels-01.png"
        ).right()
}