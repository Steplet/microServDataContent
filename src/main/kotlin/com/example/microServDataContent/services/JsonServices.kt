package com.example.microServDataContent.services

import com.example.microServDataContent.Model.Model
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class JsonServices {


    public fun createJsonFromList(list:List<Model>): JSONObject {
        val json = JSONObject()
        var counter = 0
        for(i in list){
            counter += 1
            json.put(counter.toString(), i)
        }

        return json
    }

}