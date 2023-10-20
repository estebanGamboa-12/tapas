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
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fgrantourismotravels.com%2Fspanish-meatballs-recipe-albondigas%2F&psig=AOvVaw2399YYsSj46p1oM_tLDUEk&ust=1697895754273000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJC5373fhIIDFQAAAAAdAAAAABAE",
            "albondigas tapas",
            "vermuteria",
            "Total:3",
            "Media:2",
            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn.icon-icons.com%2Ficons2%2F1945%2FPNG%2F512%2Ficonfinder-share-4661629_122485.png&tbnid=KKVnb62G8wEQTM&vet=12ahUKEwjxuI2j4YSCAxWJuScCHc2HAPMQMygIegQIARBe..i&imgrefurl=https%3A%2F%2Ficon-icons.com%2Fes%2Ficono%2Fcompartir%2F122485&docid=ye1gabTpFV0JMM&w=512&h=512&q=icono%20compartir&ved=2ahUKEwjxuI2j4YSCAxWJuScCHc2HAPMQMygIegQIARBe",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.creativefabrica.com%2Fes%2Fproduct%2Flike-icon-26%2F&psig=AOvVaw3GP34IlBXqo8gxGB75ngye&ust=1697895923915000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJjVwI7ghIIDFQAAAAAdAAAAABAL"
        ).right()
}