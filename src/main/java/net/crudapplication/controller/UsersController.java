package net.crudapplication.controller;

import lombok.AllArgsConstructor;
import net.crudapplication.dto.UsersDto;
import net.crudapplication.entity.Users;
import net.crudapplication.repository.UsersRepository;
import net.crudapplication.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UsersService usersService;


    //Build Add Users RestAPI
    @PostMapping
    public ResponseEntity<UsersDto> createUsers(@RequestBody UsersDto usersDto){
        UsersDto savedUsers = usersService.createUsers(usersDto);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    // Build GET Users RestAPI
    @GetMapping("{id}")
    public ResponseEntity<UsersDto> getUsersbyId(@PathVariable("id") Integer usersId){
        UsersDto usersDto = usersService.getUsersById(usersId);
        return ResponseEntity.ok(usersDto);
    }

    // Build Get ALL users RestAPI
    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        List<UsersDto> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Build Update Users RestAPI
    @PutMapping("{id}")
    public ResponseEntity<UsersDto> updateUsers(@PathVariable("id") Integer usersId,
                                                @RequestBody UsersDto updatedUsers){
        UsersDto usersDto= usersService.updateUsers(usersId, updatedUsers);
        return ResponseEntity.ok(usersDto);
    }

    // Build Delete Users RestAPI
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable("id") Integer usersId){
        usersService.deleteEmployee(usersId);
        return ResponseEntity.ok("Employee deleted Successfully!");
    }
}
