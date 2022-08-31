package zxf.springboot.authservicea.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("principal", (LdapUserDetails) authentication.getPrincipal());
        return modelAndView;
    }
}
