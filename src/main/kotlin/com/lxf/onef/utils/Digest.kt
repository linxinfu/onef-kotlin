package com.lxf.onef.utils

import java.security.NoSuchAlgorithmException
import java.security.MessageDigest


/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

object Digest {
    fun sha256(msg: String): String {
        return Encode.bytesToHexString(sha256Byte(msg))
    }


    private fun sha256Byte(msg: String): ByteArray {
        try {
            val sha256 = MessageDigest.getInstance("SHA-256")
            sha256.update(msg.toByteArray())
            return sha256.digest()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ByteArray(0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var a = "787789787878978984623462364"
        var b = ByteArray(0)
        for (i in 0 until 1000) {
            b = sha256Byte(a)
        }
        println(Encode.bytesToHexString(b))
    }
}