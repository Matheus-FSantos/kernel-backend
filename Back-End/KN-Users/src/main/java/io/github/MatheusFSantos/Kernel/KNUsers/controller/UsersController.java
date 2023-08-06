package io.github.MatheusFSantos.Kernel.KNUsers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @GetMapping
    public ResponseEntity<?> findAll() {
        //complete find all method
        return ResponseEntity.ok().body("findAll");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        //complete find by id method
        return ResponseEntity.ok().body("findById");
    }

    @PostMapping
    public ResponseEntity<?> save() {
        //complete save method
        return ResponseEntity.ok().body("save");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        //complete update method
        return ResponseEntity.ok().body("update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        //complete delete method
        return ResponseEntity.ok().body("delete");
    }

}
