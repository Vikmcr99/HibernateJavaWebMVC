package br.edu.infnet.SpringMVC.Model.Repository;

import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {

    @Query("from Friend f where f.user.id=:id")
    List<Friend> getFriendsByUser(Integer id, Sort by);
}
