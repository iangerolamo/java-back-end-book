package io.github.iangerolamo.userapi.controller;

import dto.UserDTO;
import exception.UserNotFoundException;
import io.github.iangerolamo.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("users/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(
            @RequestParam(name="key") String key,
            @PathVariable String cpf) {
        return userService.findByCpf(cpf, key);
    }

    @DeleteMapping("user/{id}")
    UserDTO delete(@PathVariable Long id) throws UserNotFoundException {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
            @RequestParam(name="nome", required = true) String nome) {
        return userService.queryByName(nome);
    }
}
