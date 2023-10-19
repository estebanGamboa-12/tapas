package com.example.albondigas.domain

import com.example.albondigas.app.Either
import com.example.albondigas.app.ErrorApp

class GetTapasUseCase (private  val repository: TapasRepository){

     operator  fun invoke():Either<ErrorApp,Tapas>{

         return repository.obtainTapas()
     }
}