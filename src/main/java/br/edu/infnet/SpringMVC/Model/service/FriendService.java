package br.edu.infnet.SpringMVC.Model.service;


import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.Repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;


    public List<Friend> getAllFriends() {
        return (List<Friend>) friendRepository.findAll();
    }

    public List<Friend> getFriendsByUser(User user) {
        return (List<Friend>) friendRepository.getFriendsByUser(user.getId(), Sort.by(Sort.Direction.ASC, "name"));
    }


    public Friend getById(Integer id) {
        return friendRepository.findById(id).get();
    }

    public void save(Friend friend) {
        friendRepository.save(friend);
    }

    public void delete(Integer id) {
        friendRepository.deleteById(id);
    }

}
