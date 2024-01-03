package com.rinha.rinhadebackend.repository

import com.rinha.rinhadebackend.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository: JpaRepository<Pessoa, Long>
