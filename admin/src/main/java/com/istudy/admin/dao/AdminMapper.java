package com.istudy.admin.dao;

import com.istudy.admin.pojo.AdminDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminDO record);

    int insertSelective(AdminDO record);

    AdminDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminDO record);

    int updateByPrimaryKey(AdminDO record);

    int verifyPassword(String username, String password);
}
