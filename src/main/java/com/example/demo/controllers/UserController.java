package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Punto A-a de la prueba tecnica
    @PostMapping("/create")
    public UserModel saveUser(@RequestBody UserModel usuario){
        return this.userService.saveUser(usuario);
    }

    //Punto A-b de la prueba tecnica
    @GetMapping
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    //Punto A-c de la prueba tecnica
    @GetMapping("/query")
    public List<UserModel> findByEmail(@RequestParam("email") String email){
        return this.userService.findByEmail(email);
    }

    //Punto A-d de la prueba tecnica
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "se elimino el usuario con el id " + id;
        } else {
            return "no se ha logrado eliminar el usuario con el id " + id;
        }

    }


}
