package com.ehualu.rise.dao.user;

import java.util.List;

import com.ehualu.rise.pojo.user.UserVehicle;


public interface UserVehicleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVehicle record);

    int insertSelective(UserVehicle record);

    UserVehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVehicle record);

    int updateByPrimaryKey(UserVehicle record);
    
    List<UserVehicle> queryByUsername(String username);
    
    int deleteSelective(UserVehicle userVehicle);
    
    UserVehicle queryUserVehicle(UserVehicle userVehicle);
}