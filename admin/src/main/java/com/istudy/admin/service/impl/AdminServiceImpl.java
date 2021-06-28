package com.istudy.admin.service.impl;

import com.istudy.admin.dao.AdminMapper;
import com.istudy.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean veritypasswd(String name, String password) {
        return adminMapper.verifyPassword(name, password) > 0 ? true : false;
    }
}

