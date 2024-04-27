package net.crudapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Integer id;
    private String username;
    private String password;
    private String nip;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
//    private String createBy;
//    private String UpdatedBy;
}
