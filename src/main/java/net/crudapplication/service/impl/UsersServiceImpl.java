package net.crudapplication.service.impl;

import lombok.AllArgsConstructor;
import net.crudapplication.dto.UsersDto;
import net.crudapplication.entity.Users;
import net.crudapplication.exception.ResourceNotFoundException;
import net.crudapplication.mapper.UsersMapper;
import net.crudapplication.repository.UsersRepository;
import net.crudapplication.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;



    @Override
    public UsersDto createUsers(UsersDto usersDto) {

        Users users = UsersMapper.mapToUsers(usersDto);
        Users savedUsers = usersRepository.save(users);



        return UsersMapper.mapToUsersDto(savedUsers);
    }

    @Override
    public UsersDto getUsersById(Integer usersId) {
        Users users =  usersRepository.findById(usersId)
                .orElseThrow(() -> new ResourceNotFoundException("Users is not exist with given id : " + usersId));
        return UsersMapper.mapToUsersDto(users);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map((user) -> UsersMapper.mapToUsersDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto updateUsers(Integer usersId, UsersDto updatedUsers) {


        Users user = usersRepository.findById(usersId).orElseThrow(
                () -> new ResourceNotFoundException("Users is not exist with given id : " + usersId)
        );

        user.setNip(updatedUsers.getNip());
        user.setUsername(updatedUsers.getUsername());
        user.setPassword(updatedUsers.getPassword());
        Users updatedUsersObj = usersRepository.save(user);

        return UsersMapper.mapToUsersDto(updatedUsersObj);
    }

    @Override
    public void deleteEmployee(Integer usersId) {
        Users user = usersRepository.findById(usersId).orElseThrow(
                () -> new ResourceNotFoundException("Users is not exist with given id : " + usersId)
        );

        usersRepository.deleteById(usersId);
    }
}
