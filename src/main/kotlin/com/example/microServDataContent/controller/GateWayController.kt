package com.example.microServDataContent.controller

import com.example.microServDataContent.Model.Model
import com.example.microServDataContent.redis.Producer
import com.example.microServDataContent.repo.ModelRepo
import com.example.microServDataContent.services.FinApiServices
import com.example.microServDataContent.services.ModelServices
import org.json.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class GateWayController(val repo:ModelRepo,
                        val serviceModel: ModelServices,
                        val servicesFin:FinApiServices,
                        val producer:Producer,)
{

    val topicGate:String = "Gate"


    @PostMapping("/save/{data}")
    fun saveWithSomeData(@PathVariable data:Double){
        serviceModel.saveData(data)


    }

    @GetMapping("getData")
    fun getDataFromDatabase() {
        val data = serviceModel.showAllData()
        data.put("Command", "test")
        println(data)
        producer.publish(topicGate, data.toString())
    }

    @PostMapping("getStock")
    fun getApiStock(symbol:String, number:Int){
        val data: JSONObject = servicesFin.getApiStock(symbol, number)
        data.put("Command", "gotStock")
        producer.publish(topicGate, data.toString())
    }
}