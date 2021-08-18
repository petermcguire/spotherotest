package co.petermcguire.spotherotest.spotherotest.controller

import co.petermcguire.spotherotest.spotherotest.model.User
import co.petermcguire.spotherotest.spotherotest.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getActiveUsers(): MutableIterable<User> = userService.getActiveUsers()
}