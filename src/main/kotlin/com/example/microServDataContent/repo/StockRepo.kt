package com.example.microServDataContent.repo

import com.example.microServDataContent.Model.Stock
import org.springframework.data.repository.ListCrudRepository

interface StockRepo: ListCrudRepository<Stock, Long> {
}