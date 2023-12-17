package com.example.microServDataContent.services

import com.example.microServDataContent.Model.Stock
import org.json.JSONObject
import org.springframework.stereotype.Service

/**
 * Useful services for json manipulations
 */
@Service
class JsonServices {


    public fun createJsonFromList(list:List<Stock>): JSONObject {
        val json = JSONObject()
        var counter = 0
        for(i in list){
            counter += 1
            json.put(counter.toString(), i)
        }

        return json
    }

}