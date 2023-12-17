package com.example.microServDataContent.services

import com.example.microServDataContent.Model.Model
import com.example.microServDataContent.repo.ModelRepo
import org.json.JSONObject
import org.springframework.stereotype.Service
import kotlin.math.hypot


@Service
class ModelServices(val repo:ModelRepo,
                    val serJson:JsonServices,) {
    /**
     This function save data to Database

     * @param someData

     */
    fun saveData(data:Double){
        repo.save(Model(dataPrice = data))
    }

    fun showAllData(): JSONObject {
        val data = repo.findAll()

        return serJson.createJsonFromList(data)
    }

}