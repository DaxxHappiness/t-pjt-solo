package com.mrseo3o3.pjt_solo.repository;

import com.mrseo3o3.pjt_solo.domain.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select count(*) from users")
    int getUserCount();

    @Select("select count(*) from users where email = #{email}")
    int hasUser(String email);

    @Select("select * from users where email = #{email}")
    UserDto getUserOne(String email);

    @Insert("insert into users (email, password, name, phone) " +
            "values(#{user.email}, #{user.password}, #{user.name}, #{user.phone})")
    int addUserOne(@Param("user")UserDto userDto);
}
