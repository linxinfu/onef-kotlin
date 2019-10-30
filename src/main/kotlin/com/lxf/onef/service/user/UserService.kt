package com.lxf.onef.service.user

import com.lxf.onef.entity.User

/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */


interface UserService {
    fun register(user: User): Boolean

    fun usernameAvailable(username: String): Boolean

    fun login(username: String, password: String): User?

    fun generateToken(userId: Long): String

    fun generatePassword(salt: String, oldPassword: String): String
}