package com.rinha.rinhadebackend.model

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.io.IOException


@Converter
class StringListConverter : AttributeConverter<List<*>?, String> {
    private val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: List<*>?): String {
        try {
            return objectMapper.writeValueAsString(attribute)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException("Error converting list to JSON string", e)
        }
    }

    override fun convertToEntityAttribute(dbData: String): List<*>? {
        try {
            return objectMapper.readValue<List<*>?>(dbData, List::class.java)
        } catch (e: IOException) {
            throw IllegalArgumentException("Error converting JSON string to list", e)
        }
    }

}