package com.enit.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enit.dao.NomenclaturesTaxesRepository;
import com.enit.entites.User;
import com.enit.metiers.UserMetier;

@Controller
public class SecurityController {
    @Autowired
    private UserMetier userMetier;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/",}, method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = {"/home",}, method = RequestMethod.GET)
    public String homeurl() {

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/accounts/new", method = RequestMethod.GET)
    public ModelAndView createAccountForm() {

        return new ModelAndView("signup", "user", new User());
    }

    @RequestMapping(value = "/accounts/new", method = RequestMethod.POST)
    public ModelAndView createAccount(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("signup");

            return model;
        }

        try {
            String rawPassword = user.getPassword();
            String encpsw = passwordEncoder.encode(rawPassword);
            user.setPassword(encpsw);
            userMetier.ajouterUser(user);
            return new ModelAndView("login");
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("signup");
            model.addObject("user", user);
            model.addObject("message", e.getMessage());
            return model;
        }


    }


}
