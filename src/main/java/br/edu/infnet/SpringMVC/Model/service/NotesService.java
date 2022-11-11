package br.edu.infnet.SpringMVC.Model.service;


import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.Notes;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;


    public List<Notes> getAllNotes() {
        return (List<Notes>) notesRepository.findAll();
    }

    public List<Notes> getNotesByUser(User user) {
        return (List<Notes>) notesRepository.getNotesByUser(user.getId(), Sort.by(Sort.Direction.ASC, "title"));
    }


    public Notes getById(Integer id) {
        return notesRepository.findById(id).get();
    }

    public void save(Notes notes) {
        notesRepository.save(notes);
    }

    public void delete(Integer id) {
        notesRepository.deleteById(id);
    }

}
