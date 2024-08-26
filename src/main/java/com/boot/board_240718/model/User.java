package com.boot.board_240718.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
//Entity가 다른 Entity와 연관관계가 있는 상태에서 @Date 어노테이션으로 Lombok이 생성하는 메서드들이 순환참조하여 error 발생
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    Set<Course> likedCourses;
    @JsonIgnore //json data 뺑뺑이 돌지 말라고
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

}


