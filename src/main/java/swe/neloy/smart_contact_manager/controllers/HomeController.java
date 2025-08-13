/* 
Created by Neloy on 10 August, 2025.
Email: taufiqneloy.swe@gmail.com
*/

package swe.neloy.smart_contact_manager.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import swe.neloy.smart_contact_manager.data_access_objects.UserRepository;
import swe.neloy.smart_contact_manager.entities.User;
import swe.neloy.smart_contact_manager.helpers.Message;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/test")
//    @ResponseBody
//    public String test() {
//        User user = new User();
//        user.setName("Neloy");
//        user.setEmail("taufiqneloy.swe@gmail.com");
//        user.setPassword("123456");
//        user.setRole("user");
//
//        user.setEnabled(true);
//        user.setImageUrl("hello");
//        user.setAbout("Software Engineer");
//
//        userRepository.save(user);
//        return "Working";
//    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title", "Sign up - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    //handler for user signup:
    @RequestMapping(value = "/doSignup", method = RequestMethod.POST)
    public String doSignup(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, RedirectAttributes redirectAttributes){
        try{
            if(!agreement){
                System.out.println("please check terms and condition");
                throw new Exception("please check terms and condition");
            }
//        System.out.println("Agreement::: "+agreement);
//        System.out.println("user::: "+user);

            if(bindingResult.hasErrors()){
                model.addAttribute("user", user);
                return "signup";
            }

            user.setRole("roleUser");
            user.setEnabled(true);
//            User result = this.userRepository.save(user);
            this.userRepository.save(user);
            model.addAttribute("user", new User());
            redirectAttributes.addFlashAttribute("alertTermCondition", new Message("Successfully Registered !!", "alert-success"));
            return "redirect:/signup";
        } catch (Exception e){
            model.addAttribute("user", user);
            redirectAttributes.addFlashAttribute("alertTermCondition", new Message(e.getMessage(), "alert-danger"));
            return "redirect:/signup";
        }
    }
}
