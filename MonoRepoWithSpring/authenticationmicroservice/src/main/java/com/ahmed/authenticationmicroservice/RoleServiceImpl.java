package com.ahmed.authenticationmicroservice;
import com.ahmed.authenticationmicroservice.Role;
import com.ahmed.authenticationmicroservice.RoleRepository;
import com.ahmed.authenticationmicroservice.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository ;
    @Override
    public Role saveRole(Role role) {
        log.info("save the rule   : {} " , role.getName());
        return roleRepository.save( role );
    }
}