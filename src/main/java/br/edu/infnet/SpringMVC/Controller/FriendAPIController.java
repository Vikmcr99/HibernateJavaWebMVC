package br.edu.infnet.SpringMVC.Controller;

import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.service.FriendService;
import br.edu.infnet.SpringMVC.Model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/restfriends")
public class FriendAPIController {
    @Autowired
    private FriendService friendService;


    public FriendAPIController() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Friend>> getAll() {
        List<Friend> friends = friendService.getAllFriends();

        if (friends == null || friends.isEmpty()) {
            return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Friend> get(@PathVariable("id") int id) {
        try {
            Friend friend = friendService.getById(id);

            return new ResponseEntity<Friend>(friend, HttpStatus.OK);

        } catch (NoSuchElementException ns) {
            return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Friend> create(@RequestBody Friend friend) {
       
        friendService.save(friend);

        return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") int id) {

        friendService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Friend> update(@PathVariable int id, @RequestBody Friend friend) {

        try {
            Friend friends = friendService.getById(id);

            friends.setName(friend.getName());
            friends.setNumber(friend.getNumber());
            friends.setCountry(friend.getCountry());

           
            friendService.save(friends);

            return new ResponseEntity<Friend>(friends, HttpStatus.OK);

        } catch (NoSuchElementException ns) {
            return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
        }
    }

}