package com.uabc.edu.appswbd.demo_examen.service;

import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.demo_examen.MyUserDetails;
import com.uabc.edu.appswbd.demo_examen.model.User;
import com.uabc.edu.appswbd.demo_examen.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }

    public List<User> getUsers() {
        return (List<User>) repo.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return repo.findById(id).get();
        }
        return user.get();
    }

    public User saveUser(User e) {
        
        if (e.getId() == null) {
            e = repo.save(e);
            return e;
        } else {

            Optional<User> user = repo.findById(e.getId());

            if (user.isPresent()) {

                User newUser = user.get();
                newUser.setId(e.getId());
                newUser.setUserName(e.getUserName());
                newUser.setPassword(e.getPassword());
                newUser.setActive(e.isActive());
                newUser.setRoles(e.getRoles());
                repo.deleteById(e.getId());
                newUser = repo.save(newUser);
                return newUser;
            } else {
                e = repo.save(e);
                return e;
            }
        }
    }

    public void deleteUser(Integer id) {

        Optional<User> user = repo.findById(id);

        if (user.isPresent()) {
            repo.deleteById(id);
        }
    }

}