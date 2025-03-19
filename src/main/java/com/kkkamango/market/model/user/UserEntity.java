package com.kkkamango.market.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
/**
 * 회원 Master entity
 */
public class UserEntity implements Serializable {

    /**
     * 회원ID
     */
    @Id
    private String id;

    /**
     * 회원이름
     */
    private String fullname;

    /**
     * 생년월일
     */
    private String birthday;

    /**
     * 회원CI
     */
    private String ci;

    /**
     * 회원등급(일반/VIP)
     */
    private String grade;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(nullable = false, length = 1, columnDefinition = "char default 'N'", insertable = false)
    private String delYn;

//    /**
//     * 암호화 비밀번호
//     */
//    private String password;
//
//    /**
//     * 비밀번호 salt
//     */
//    private String salt;
//
//    /**
//     * 계정 잠김 여부
//     */
//    private String isLock;
//
//    /**
//     * 비밀번호 재시도 횟수
//     */
//    private Integer passwordRetryCount;
//
//    /**
//     * 마지막 로그인 일시
//     */
//    private LocalDateTime lastLoginDatetime;
//
//    /**
//     * 마지막 비밀번호 변경 일시
//     */
//    private String lastPasswordResetDate;
}
