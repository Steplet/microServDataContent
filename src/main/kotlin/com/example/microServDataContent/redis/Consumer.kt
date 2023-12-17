package com.example.microServDataContent.redis

import com.example.microServDataContent.controller.GateWayController
import org.json.JSONObject
import org.springframework.context.annotation.Lazy
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

/**
 * Simple Redis Consumer for Pub/Sub Broker
 *
 */
@Component
class Consumer(@Lazy val gate:GateWayController):MessageListener {
    /**
     * Listener of messages
     */
    override fun onMessage(message: Message, pattern: ByteArray?) {

        //clear mess

        var mes = message.toString().replace("\\", "")
        mes = mes.replace(Regex("^\"|\"$"), "")
        val json = JSONObject(mes)

        val cmd = json.get("Command")

        //switch case for action

        when (cmd){

            //add Stock to rep and send
            "addStock" ->{
                val symbol:String = json.getString("symbol")
                val number:Int = json.getInt("Number")

                gate.addApiStock(symbol, number)
            }

            //show all stocks from rep

            "getAllStocks" -> {
                gate.getAllStocks()
            }

            //del stock from rep by id
            "delById" ->{
                val id:Int = json.getInt("id")

                gate.delStockById(id)
            }

            //show price of stock by symbol
            "showPriceStock" -> {
                val symbol:String = json.getString("symbol")
                gate.showPriceStock(symbol)
            }
            else ->{
                println("Wrong: bad mes!")
            }

        }
    }


}