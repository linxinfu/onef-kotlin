package com.lxf.onef.dao

import com.lxf.onef.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

/**
 * Created by lxf.
 * Description:
 * Date: 2019-10-30
 */


const val TABLE_NAME = "user"

@Repository
@Mapper
interface UserDao {
    @Insert("INSERT INTO ", TABLE_NAME, "(id,username,name,phone,password,salt) " + "VALUES(#{id},#{username},#{name},#{phone},#{password},#{salt})")
    fun insertUser(user: User): Int

    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    fun countByUsername(username: String): Int

    @Select("SELECT * FROM user WHERE username = #{username}")
    fun selectByUsername(username: String): User?
}