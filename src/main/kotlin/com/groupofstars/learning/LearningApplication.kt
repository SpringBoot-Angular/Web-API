package com.groupofstars.learning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class LearningApplication{

}
@RestController
class MessageControl(private val messageService: MessageService) {
	@GetMapping("/")
	fun index(@RequestParam("name") name:String) = listOf(
		Message(name,name),
		Message(name,name),
		Message(name,name),
	)
	@PostMapping("/")
	fun post(@RequestBody message: Message):Int {
		return messageService.save(message)
	}
	@GetMapping("{id}")
	fun get(@PathVariable("id") id:String) = messageService.findOne(id)

}

fun main(args: Array<String>) {
	runApplication<LearningApplication>(*args)
}
