package com.lxf.onef.service.common

import com.lxf.onef.utils.SnowFlake
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

@Service
class CommonService {

    companion object {
        const val EXPIRE_TIME = 3 * 24 * 60 * 60 * 1000
    }

    @Value("\${snow-flake.data-center-id}")
    private val dataCenterID: Long = 1

    @Value("\${snow-flake.machine-id}")
    private val machineId: Long = 1

    @Value("\${jwt-salt}")
    private val jwtSalt: String = ""

    val sf = SnowFlake(dataCenterID, machineId)

    /**
     *  雪花算法生成表格唯一ID
     */
    fun genTableID(): Long {
        return sf.nextId()
    }

    /**
     *  签发Token
     */
    fun signToken(userId: Long): String = Jwts.builder()
            .setSubject(userId.toString())
            .setExpiration(Date(System.currentTimeMillis() + EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS512, jwtSalt)
            .compact()

    /**
     *  解析Token
     */
    fun parseToken(token: String): Long? {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSalt)
                    .parseClaimsJws(token)
                    .body
                    .subject
                    .toLong()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


}