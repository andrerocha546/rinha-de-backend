package com.rinha.rinhadebackend.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
class Pessoa(
    @Column(unique = true, nullable = false, length = 32)
    val apelido: String? = null,

    @Column(nullable = false, length = 100)
    val nome: String? = null,

    @Column(nullable = false, length = 10)
    val nascimento: String? = null,

    @Column(columnDefinition = "TEXT")
    @Convert(converter = StringListConverter::class)
    val stack: List<String> = emptyList()
) {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID? = null
}