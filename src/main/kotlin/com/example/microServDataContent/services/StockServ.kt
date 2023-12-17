package com.example.microServDataContent.services

import com.example.microServDataContent.Model.Stock
import com.example.microServDataContent.repo.StockRepo
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class StockServ(val repoStock: StockRepo,) {

    fun fromJsonToStock(json:JSONObject): Stock {
        var stock : Stock = Stock(
            companyName = json.getString("companyName"),
            latestPrice = json.getInt("latestPrice"),
            totalValue = json.getInt("totalValue"))
        return stock

    }
    fun addTpRepo(stock:Stock){
        repoStock.save(stock)
    }
}