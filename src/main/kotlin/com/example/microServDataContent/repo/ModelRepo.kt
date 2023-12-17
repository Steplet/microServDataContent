package com.example.microServDataContent.repo

import com.example.microServDataContent.Model.Model
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ModelRepo:ListCrudRepository<Model, Long> {

}