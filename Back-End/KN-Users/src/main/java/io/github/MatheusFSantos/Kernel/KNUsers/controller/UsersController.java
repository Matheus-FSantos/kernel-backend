package io.github.MatheusFSantos.Kernel.KNUsers.controller;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.Users;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() throws UsersException {
        return ResponseEntity.ok().body(this.usersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable String id) throws UsersException {
        return ResponseEntity.ok().body(this.usersService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UsersDTO> save(@RequestBody UsersDTO usersDTO) throws UsersException {
        this.usersService.save(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        //call service
        return ResponseEntity.ok().body("update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws UsersException {
        this.usersService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
