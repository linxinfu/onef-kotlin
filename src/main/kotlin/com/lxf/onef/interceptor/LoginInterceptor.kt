package com.lxf.onef.interceptor

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by lxf.
 * Description: 登录验证拦截器
 * Date: 2019-11-01
 */

@Component
class LoginInterceptor : HandlerInterceptor {
    private val logger = LoggerFactory.getLogger(LoginInterceptor::class.java)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // TODO 验证TOKEN
        val token = request.getHeader("Authorization")
        println("拦截到的token：$token")
        return super.preHandle(request, response, handler)
    }
}

