package com.rinha.rinhadebackend.service

import com.rinha.rinhadebackend.controller.Pessoa
import com.rinha.rinhadebackend.model.Pessoa as PessoaModel
import com.rinha.rinhadebackend.repository.PessoaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PessoaService(
    private val repository: PessoaRepository
) {

    fun createPeople(pessoa: Pessoa): Long? {
        val model = PessoaModel(
            nome = pessoa.nome,
            apelido = pessoa.apelido,
            nascimento = pessoa.nascimento
        )
        try {
            val pessoa = repository.save(model)
            return pessoa.id!!
        } catch (ex: RuntimeException) {
            return null
        }
    }

    fun getPessoaById(id: Long): PessoaModel? {
        return repository.findByIdOrNull(id)
    }

    fun getPessoasCount(): Long {
        return repository.count()
    }

}