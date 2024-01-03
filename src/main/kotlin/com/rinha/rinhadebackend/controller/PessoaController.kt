package com.rinha.rinhadebackend.controller

import com.rinha.rinhadebackend.service.PessoaService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PessoaController(
    private val service: PessoaService
) {

    @PostMapping(value = ["pessoas"])
    fun createPessoa(@RequestBody pessoa: Pessoa): ResponseEntity<HttpStatus> {
        val id: Long? = service.createPeople(pessoa)

        if (id != null) {
            val headers = HttpHeaders()
            headers.set("Location", "/pessoas/${id}")

            return ResponseEntity<HttpStatus>(headers, HttpStatus.CREATED)
        } else {
            return ResponseEntity<HttpStatus>(HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }

    @GetMapping(value = ["pessoas/{id}"])
    fun getPessoaById(@PathVariable id: Long): String {
        return "get $id"
    }

    @GetMapping(value = ["pessoas"])
    fun getPessoaByTerm(@RequestParam("t") term: String): String {
        return "get $term"
    }

    @GetMapping(value = ["contagem-pessoas"])
    fun getPessoaCount(): String {
        return "get 300"
    }

}