package net.crudapplication.mapper;

import net.crudapplication.dto.UsersDto;
import net.crudapplication.entity.Users;

public class UsersMapper {
    public static UsersDto mapToUsersDto(Users users){
        return new UsersDto(
                users.getId(),
                users.getUsername(),
                users.getPassword(),
                users.getNip(),
                users.getCreateDate(),
                users.getUpdatedDate()
//                users.getCreateBy(),
//                users.getUpdatedBy()
        );

    }

    public static Users mapToUsers(UsersDto usersDto){
        return new Users(
                usersDto.getId(),
                usersDto.getUsername(),
                usersDto.getPassword(),
                usersDto.getNip(),
                usersDto.getCreateDate(),
                usersDto.getUpdatedDate()
//                usersDto.getCreateBy(),
//                usersDto.getUpdatedBy()
        );
    }
}
