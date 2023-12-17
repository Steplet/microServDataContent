package com.example.microServDataContent.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "modelTable")
data class Model(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = -1,
    val dataPrice : Double
    )


