package com.example.albondigas.data.local

import android.content.Context
import com.example.albondigas.app.Either
import com.example.albondigas.app.ErrorApp
import com.example.albondigas.app.left
import com.example.albondigas.app.right
import com.example.albondigas.domain.Tapas
import com.iesam.androidviews.app.serialization.JsonSerialization

class TapasLocalDataSource (
    private val context: Context,
    private val serialization: JsonSerialization
        ){

    private val sharedPref= context.getSharedPreferences("tapas",Context.MODE_PRIVATE )
    private val tapasId="1";

    fun getTapas():Either<ErrorApp,Tapas>{
        val jsonTapas=sharedPref.getString(tapasId,null)
        jsonTapas?.let {
            return serialization.fromJson(it,Tapas::class.java).right()
        }
        return  ErrorApp.DataError.left()
    }
    fun save(tapas: Tapas){
        sharedPref.edit().apply(){
         putString(tapasId,serialization.toJson(tapas,Tapas::class.java))
         apply()
        }
    }

}