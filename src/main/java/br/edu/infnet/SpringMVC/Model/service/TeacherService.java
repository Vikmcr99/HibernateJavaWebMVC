package br.edu.infnet.SpringMVC.Model.service;


import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.Teacher;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    public List<Teacher> getTeacherByUser(User user) {
        return (List<Teacher>) teacherRepository.getTeachersByUser(user.getId(), Sort.by(Sort.Direction.ASC, "name"));
    }


    public Teacher getById(Integer id) {
        return teacherRepository.findById(id).get();
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }

}
