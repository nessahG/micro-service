package com.ahmed.authenticationmicroservice;

import com.ahmed.authenticationmicroservice.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role saveRole(Role role) ;
}

