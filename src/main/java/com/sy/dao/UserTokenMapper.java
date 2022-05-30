package com.sy.dao;


import com.sy.entity.UserToken;

//@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {

    UserToken getToken(String token);

}
