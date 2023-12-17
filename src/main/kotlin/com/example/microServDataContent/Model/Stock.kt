package com.example.microServDataContent.Model

import jakarta.persistence.*

@Entity
@Table(name = "StockTable")
data class Stock(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int = -1,
    val companyName:String = "",
    val latestPrice:String = "",
    val totalValue:Int = 0,
)

