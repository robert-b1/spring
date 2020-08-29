package test.demo.spring.core.basik.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String hello(){
        return "Publicne Witam";
    }

    @GetMapping("/private")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String hellPrivate(){
        return "Prywatne witam";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String helloAdmin(){
        return "Administracyjny witam";
    }
}
