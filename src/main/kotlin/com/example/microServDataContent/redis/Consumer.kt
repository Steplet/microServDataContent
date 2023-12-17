package com.example.microServDataContent.redis

import com.example.microServDataContent.controller.GateWayController
import org.json.JSONObject
import org.springframework.context.annotation.Lazy
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class Consumer(@Lazy val gate:GateWayController):MessageListener {
    override fun onMessage(message: Message, pattern: ByteArray?) {

        var mes = message.toString().replace("\\", "")
        mes = mes.replace(Regex("^\"|\"$"), "")
//        println(mes)
        val json = JSONObject(mes)

        val cmd = json.get("Command")


        when (cmd){
            "Hello" -> gate.getDataFromDatabase()
            "getStock" ->{
                val symbol:String = json.getString("symbol")
                val number:Int = json.getInt("Number")
                gate.getApiStock(symbol, number)
            }
            else ->{
                println("Wrong: bad mes!")
            }

        }
    }


}