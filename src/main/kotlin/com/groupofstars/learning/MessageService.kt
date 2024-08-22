package com.groupofstars.learning

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db:JdbcTemplate) {
    fun findAll(): List<Message> {
        return db.query("select * from messages") { responseArray, rowNumber ->
            Message(responseArray.getString(rowNumber),responseArray.getString("text"))
        }
    }
    fun findOne(id:String): List<Message> {
        return db.query("select * from messages where id = ?",id) { response , _ ->
            Message(response.getString("id"),response.getString("text"))
        }
    }
    fun save(message: Message) : Int {
        val id = message.id ?: UUID.randomUUID().toString();
        return db.update("insert into messages values ( ?, ? ) ", id,message.text)
    }
}