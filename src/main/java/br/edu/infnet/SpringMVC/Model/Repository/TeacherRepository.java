package br.edu.infnet.SpringMVC.Model.Repository;

import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Query("from Teacher t where t.user.id=:id")
    List<Teacher> getTeachersByUser(Integer id, Sort by);
}
