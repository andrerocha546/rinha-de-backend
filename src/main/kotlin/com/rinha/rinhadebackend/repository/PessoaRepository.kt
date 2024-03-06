package com.rinha.rinhadebackend.repository

import com.rinha.rinhadebackend.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface PessoaRepository: JpaRepository<Pessoa, UUID> {

    @Query("SELECT p FROM Pessoa p " +
            "WHERE p.nome LIKE %:term% " +
            "OR p.apelido LIKE %:term% " +
            "OR CONCAT(p.stack) LIKE %:term%")
    fun findByTerm(term: String): List<Pessoa?>?

}
