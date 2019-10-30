package com.lxf.onef.utils

import java.io.Serializable


/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */

class Response<T>(
        val status: Int = 0,
        val msg: String? = null,
        val data: T? = null
) : Serializable {

    companion object {

        fun <T> success(msg: String, data: T? = null): Response<T> {
            return Response(ResponseCode.SUCCESS.code, msg, data)
        }

        fun <T> error(msg: String, data: T? = null): Response<T> {
            return Response(ResponseCode.ERROR.code, msg, data)
        }
    }

}

enum class ResponseCode(val code: Int, val desc: String) {
    SUCCESS(1, "SUCCESS"),
    ERROR(0, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT")
}