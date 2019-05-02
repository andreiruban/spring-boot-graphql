package app.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Resource {

    @GetMapping("/")
    fun hello() = "Hello World!"

}