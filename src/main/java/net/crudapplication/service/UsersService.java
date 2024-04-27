package net.crudapplication.service;

import net.crudapplication.dto.UsersDto;
import net.crudapplication.entity.Users;

import java.util.List;

public interface UsersService {
    UsersDto createUsers(UsersDto usersDto);

    UsersDto getUsersById(Integer usersId);

    List<UsersDto> getAllUsers();

    UsersDto updateUsers(Integer usersId, UsersDto updatedUsers);

    void deleteEmployee(Integer usersId);
}
