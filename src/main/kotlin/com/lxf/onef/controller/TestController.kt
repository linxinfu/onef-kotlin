package com.lxf.onef.controller

import com.lxf.onef.service.user.UserService
import com.lxf.onef.service.common.CommonService
import com.lxf.onef.utils.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var commonService: CommonService

    @GetMapping("/api/v1/hello")
    fun helloWorld(): Response<String> {
        return Response.success("你好啊")
    }
}
