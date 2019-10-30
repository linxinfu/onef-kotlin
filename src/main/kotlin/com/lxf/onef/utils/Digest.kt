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
        var sha256Bin = ByteArray(0)
        try {
            val sha256 = MessageDigest.getInstance("SHA-256")
            sha256.update(msg.toByteArray())
            sha256Bin = sha256.digest()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return Encode.bytesToHexString(sha256Bin)
    }
}