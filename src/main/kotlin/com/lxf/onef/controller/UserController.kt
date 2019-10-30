package com.lxf.onef.controller

import com.lxf.onef.entity.User
import com.lxf.onef.service.user.UserService
import com.lxf.onef.utils.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.HashMap
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping


/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

@RestController
@RequestMapping("/api/v1/user")
class UserController {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/register")
    fun register(@RequestBody user: User): Response<String> {
        if (user.username.isNullOrEmpty()) {
            return Response.error("Empty username!")
        }
        if (user.password.isNullOrEmpty()) {
            return Response.error("Empty password!")
        }
        if (!userService.usernameAvailable(user.username!!)) {
            return Response.error("The username is already exists!")
        }
        val success = userService.register(user)
        return if (success) {
            Response.success("Register success!")
        } else {
            Response.error("Register failed!")
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody user: User): Response<Any> {
        if (user.username.isNullOrEmpty()) {
            return Response.error("Empty username!")
        }
        if (user.password.isNullOrEmpty()) {
            return Response.error("Empty password!")
        }
        val u = userService.login(user.username!!, user.password!!)
                ?: return Response.error("Username or password is incorrect!")
        val token = userService.generateToken(u.id!!)

        val response = HashMap<String, Any>()
        response["token"] = token
        response["user"] = User().apply {
            this.id = u.id
            this.username = u.username
            this.name = u.name
            this.phone = u.phone
            this.createdAt = u.createdAt
        }
        logger.info(user.username + " login...")
        return Response.success("Login success!", response)
    }
}