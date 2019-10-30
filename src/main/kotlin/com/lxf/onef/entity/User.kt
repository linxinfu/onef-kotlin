package com.lxf.onef.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.sql.Timestamp

/**
 * Created by lxf.
 * Description: 用户实体类
 * Date: 2019-10-30
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
data class User(
        var id: Long? = null,
        @JsonIgnore
        var isValid: Boolean? = null,
        var username: String? = null,
        var name: String? = null,
        var phone: String? = null,
        var password: String? = null,
        var salt: String? = null,
        @JsonProperty("created_at")
        var createdAt: Timestamp? = null
) {
    override fun toString(): String {
        return "User(id=$id, isValid=$isValid, username=$username, name=$name, phone=$phone, password=$password, salt=$salt, createdAt=$createdAt)"
    }
}