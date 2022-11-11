package br.edu.infnet.SpringMVC.Model.Repository;

import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.Notes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Integer> {

    @Query("from Notes n where n.user.id=:id")
    List<Notes> getNotesByUser(Integer id, Sort by);
}
