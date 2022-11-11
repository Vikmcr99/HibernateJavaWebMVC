package br.edu.infnet.SpringMVC.Model.service;


import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User auth(String mail, String password) {
        return userRepository.auth(mail, password);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.getAllUsers(Sort.by(Sort.Direction.ASC, "name"));
    }

    public User getByMail(String mail) {
        return userRepository.getByMail(mail);
    }
}

