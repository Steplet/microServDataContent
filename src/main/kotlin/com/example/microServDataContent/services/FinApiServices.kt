package com.example.microServDataContent.services

import com.example.microServDataContent.Model.Model
import org.json.JSONObject
import org.springframework.stereotype.Service
import java.net.URL


@Service
class FinApiServices {
    val apiKey = "pk_efc53ee82d5449ffa676fa6d4ed7a7e1"
//    val url = "https://api.iex.cloud/v1/data/core/quote/msft?token=$apiKey"
//    val urlStock = "https://api.iex.cloud/v1/data/core/quote/msft?token=$apiKey"
    val urlGetStock = "https://api.iex.cloud/v1/data/core/quote/"

    fun getApiStock(symbol:String): JSONObject {

        var response =
            URL(urlGetStock.plus(symbol).plus("?token=").plus(apiKey))
                .openStream()
                .bufferedReader()
                .use { it.readText() }

        response = response.replace(Regex("\\[|\\]"), "")
        val json = JSONObject(response)
//        println(json)
        return json

    }

}