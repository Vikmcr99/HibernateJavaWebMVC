package br.edu.infnet.SpringMVC.Model.Repository;


import br.edu.infnet.SpringMVC.Model.Domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("from User u where u.mail=:mail and u.password=:password")
    public User auth(String mail, String password);

    @Query("from User")
    List<User> getAllUsers(Sort by);

    @Query("from User u where u.mail=:mail")
    User getByMail(String mail);
}
