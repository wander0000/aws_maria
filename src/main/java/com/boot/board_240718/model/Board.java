package com.boot.board_240718.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @Size(min=2, max=30)//크기가 2에서 30 사이여야 합니다 -> defulte 메세지
    @Size(min=2, max=30, message = "제목은 2자 이상 30자 이하입니다.")
    private String title;
    private String content;

    @ManyToOne //board 테이블과의 관계, 한명의 사용자가 여라개의 게시글을 쓸 수 있다
    @JoinColumn(name = "user_id")
    private User user;
}
