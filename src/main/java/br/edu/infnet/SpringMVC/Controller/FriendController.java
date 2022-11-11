package br.edu.infnet.SpringMVC.Controller;

import br.edu.infnet.SpringMVC.Model.Domain.Friend;
import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping(value = "/friend")
    public String showFriend(Model model, @SessionAttribute("user") User user) {

        model.addAttribute("list", friendService.getFriendsByUser(user));
        model.addAttribute("friend", new Friend());

        return "friend/friends";
    }

    @PostMapping(value = "/friend/save")
    public String saveFriend(Friend friend, @SessionAttribute("user") User user) {

        friend.setUser(user);
        friendService.save(friend);
        return "redirect:/friend";
    }

    @GetMapping(value = "/friend/{id}/delete")
    public String deleteFriend(Model model, @PathVariable Integer id) {

        friendService.delete(id);
        return "redirect:/friend";
    }


    @RequestMapping("/friend/update")
    public ModelAndView updateFriend(Model model, @RequestParam int id) {

        ModelAndView mav = new ModelAndView("/friend/friends");
        Friend friend = friendService.getById(id);

        mav.addObject(friend);
        return mav;
    }
}
