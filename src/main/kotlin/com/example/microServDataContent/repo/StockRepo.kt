package com.example.microServDataContent.repo

import com.example.microServDataContent.Model.Stock
import org.springframework.data.repository.CrudRepository

interface StockRepo:CrudRepository<Stock, Long> {
}