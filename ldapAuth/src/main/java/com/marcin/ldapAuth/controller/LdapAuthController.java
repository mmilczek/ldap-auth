package com.marcin.ldapAuth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapAuthController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the LDAP Auth Controller";
    }

    @GetMapping("/getUserDetails")
    public String getUserDetails(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String userName = userDetails.getUsername();
        boolean accNonExpired =  userDetails.isAccountNonExpired();
        return "UserDetails: " + userName +
                "\n Account Non Expiredd: " + accNonExpired;
    }
}
