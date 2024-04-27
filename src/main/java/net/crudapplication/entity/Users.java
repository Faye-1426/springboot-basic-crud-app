// ADDING TABLE TO DATABASE

package net.crudapplication.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nip")
    private String nip;

    @CreationTimestamp
    @Column(name = "createddate", nullable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "updateddate")
    private LocalDateTime updatedDate;

//    @Column(name = "createdby", columnDefinition="varchar(255) DEFAULT CURRENT_USER", nullable = false)
//    private String createBy;
//
//    @Column(name = "updatedby", columnDefinition="varchar(255) DEFAULT CURRENT_USER", nullable = false)
//    private String updatedBy;


}
