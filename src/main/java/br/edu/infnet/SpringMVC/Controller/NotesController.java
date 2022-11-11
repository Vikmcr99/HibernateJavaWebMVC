package br.edu.infnet.SpringMVC.Controller;


import br.edu.infnet.SpringMVC.Model.Domain.Notes;
import br.edu.infnet.SpringMVC.Model.Domain.Teacher;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@Controller
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping(value = "/notes")
    public String showNotes(Model model, @SessionAttribute("user") User user) {

        model.addAttribute("notesList", notesService.getNotesByUser(user));
        model.addAttribute("notes", new Notes());

        return "notes/notes";
    }

    @PostMapping(value = "/notes/save")
    public String saveNotes(Notes notes, @SessionAttribute("user") User user) {

        notes.setUser(user);
        notesService.save(notes);
        return "redirect:/notes";
    }

    @GetMapping(value = "/notes/{id}/delete")
    public String deleteNotes(Model model, @PathVariable Integer id) {

        notesService.delete(id);
        return "redirect:/notes";
    }


    @RequestMapping("/notes/update")
    public ModelAndView updateNotes(Model model, @RequestParam int id) {

        ModelAndView mav = new ModelAndView("/notes/notes");
        Notes notes = notesService.getById(id);

        mav.addObject(notes);
        return mav;
    }
}
