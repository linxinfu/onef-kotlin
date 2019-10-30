package com.lxf.onef.service.user.impl

import com.lxf.onef.dao.UserDao
import com.lxf.onef.entity.User
import com.lxf.onef.service.user.UserService
import com.lxf.onef.service.user.common.CommonService
import com.lxf.onef.utils.Digest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID


/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userDao: UserDao
    @Autowired
    lateinit var commonService: CommonService

    override fun register(user: User): Boolean {
        val salt = UUID.randomUUID().toString()
        val password = user.password?.let { generatePassword(salt, it) }
        return userDao.insertUser(user.apply {
            this.id = commonService.genTableID()
            this.salt = salt
            this.password = password
        }) == 1
    }

    override fun usernameAvailable(username: String): Boolean {
        return userDao.countByUsername(username) <= 0
    }

    override fun login(username: String, password: String): User? {
        val user = userDao.selectByUsername(username) ?: return null
        return if (generatePassword(user.salt!!, password) == user.password) {
            user
        } else {
            null
        }
    }

    override fun generateToken(userId: Long): String {
        return commonService.signToken(userId)
    }

    override fun generatePassword(salt: String, oldPassword: String): String {
        return Digest.sha256(salt + oldPassword)
    }
}