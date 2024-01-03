package com.rinha.rinhadebackend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Pessoa(
    @Column(unique = true, nullable = false)
    val apelido: String? = null,
    @Column(nullable = false)
    val nome: String? = null,
    val nascimento: String? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}