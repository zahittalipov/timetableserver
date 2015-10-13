package com.angelectro.zt.controller;

import com.angelectro.zt.config.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zahit Talipov on 12.10.2015.
 */
@RestController
@RequestMapping("/registration_gsm")
public class RegistrationToServer {
    @RequestMapping(method = RequestMethod.GET)
    public boolean registration(@RequestParam(value = "token")String token)
    {
        Config.registration_ids.add(token);
        System.out.println("token: "+token);
        return true;
    }
}
