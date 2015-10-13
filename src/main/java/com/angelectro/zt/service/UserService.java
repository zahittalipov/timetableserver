package com.angelectro.zt.service;

import com.angelectro.zt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zahit Talipov on 10.10.2015.
 */
@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
}
