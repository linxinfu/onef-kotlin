package com.lxf.onef.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


/**
 * Created by lxf.
 * Description:  跨域配置
 * Date: 2019-10-31
 */

@Configuration
class CorsConfig {

    private fun buildConfig(): CorsConfiguration {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("*")         //  允许任何域名
        corsConfiguration.addAllowedHeader("*")  //  允许任何头
        corsConfiguration.addAllowedMethod("*")       //  允许任何方法
        return corsConfiguration
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", buildConfig())
        return CorsFilter(source)
    }
}