package com.example.albondigas.data

import com.example.albondigas.app.Either
import com.example.albondigas.app.ErrorApp
import com.example.albondigas.data.local.TapasLocalDataSource
import com.example.albondigas.data.remote.TapasRemoteDataSource
import com.example.albondigas.domain.Tapas
import com.example.albondigas.domain.TapasRepository

class TapasDataRepository(

    private val local: TapasLocalDataSource,
    private val remote: TapasRemoteDataSource

):TapasRepository {
    override fun obtainTapas(): Either<ErrorApp, Tapas> {
        var tapas = local.getTapas()
        tapas.mapLeft { errorApp ->
            return remote.getTapas().map {tapas ->
            local.save(tapas)
                tapas
            }
        }
        return tapas
    }


}