package br.edu.infnet.SpringMVC.Controller;


import br.edu.infnet.SpringMVC.Model.Domain.Teacher;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/teacher")
    public String showTeachers(Model model, @SessionAttribute("user") User user) {

        model.addAttribute("teacherList", teacherService.getTeacherByUser(user));
        model.addAttribute("teacher", new Teacher());

        return "teacher/teachers";
    }

    @PostMapping(value = "/teacher/save")
    public String saveTeacher(Teacher teacher, @SessionAttribute("user") User user) {

        teacher.setUser(user);
        teacherService.save(teacher);
        return "redirect:/teacher";
    }

    @GetMapping(value = "/teacher/{id}/delete")
    public String deleteTeacher(Model model, @PathVariable Integer id) {

        teacherService.delete(id);
        return "redirect:/teacher";
    }


    @RequestMapping("/teacher/update")
    public ModelAndView updateTeacher(Model model, @RequestParam int id) {

        ModelAndView mav = new ModelAndView("/teacher/teachers");
        Teacher teacher = teacherService.getById(id);

        mav.addObject(teacher);
        return mav;
    }
}
