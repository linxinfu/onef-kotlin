package com.lxf.onef.utils

/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

object Encode {
    fun bytesToHexString(src: ByteArray): String {
        val stringBuilder = StringBuilder("")
        if (src.isEmpty()) {
            return ""
        }
        for (i in 0 until src.size) {
            val v = src[i].toInt() and 0xFF
            val hv = Integer.toHexString(v)
            if (hv.length < 2) {
                stringBuilder.append(0)
            }
            stringBuilder.append(hv)
        }
        return stringBuilder.toString()
    }
}