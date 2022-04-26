package com.sharmsac.hportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {

    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String type;
}
