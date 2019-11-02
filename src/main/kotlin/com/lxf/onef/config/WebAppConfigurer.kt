package com.lxf.onef.config

import com.lxf.onef.interceptor.LoginInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

/**
 * Created by lxf.
 * Description:
 * Date: 2019-11-01
 */

@Configuration
class WebAppConfigurer : WebMvcConfigurationSupport() {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(getUrls())
        super.addInterceptors(registry)
    }


    /**
     *   定义需要避免过滤的url
     */
    private fun getUrls(): ArrayList<String> {
        val list: ArrayList<String> = ArrayList()
        list.add("/api/v1/user/login")
        list.add("/static/images/*")
        return list
    }
}