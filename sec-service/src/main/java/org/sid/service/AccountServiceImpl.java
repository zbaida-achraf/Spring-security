package org.sid.service;

import org.sid.dao.AppRoleRepsitory;
import org.sid.dao.AppUserRepsitory;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserRepsitory appUserRepsitory;
    @Autowired
    private AppRoleRepsitory appRoleRepsitory;

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser user=appUserRepsitory.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exist!!");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepsitory.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepsitory.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepsitory.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser=appUserRepsitory.findByUsername(username);
        AppRole appRole=appRoleRepsitory.findByRoleName(role);
        appUser.getRoles().add(appRole);
    }
}
