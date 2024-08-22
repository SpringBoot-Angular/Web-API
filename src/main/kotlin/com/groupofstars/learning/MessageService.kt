package com.groupofstars.learning

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.toList

@Service
class MessageService(val db:MessageRepository) {
    fun findAll(): List<Message> = db.findAll().toList()

    fun findOne(id:String): List<Message> = db.findById(id).toList()
    fun save(message: Message) : Message {
        return db.save(message)
    }
}