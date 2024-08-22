package com.groupofstars.learning

import org.springframework.data.repository.CrudRepository


interface MessageRepository : CrudRepository<Message, String>