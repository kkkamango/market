package com.kkkamango.market.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kkkamango.market.model.BaseEntity;
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
@Table(name = "user_account")
/**
 * 회원 계정 entity
 */
public class UserAccountEntity extends BaseEntity implements Serializable {
    @Id
    /**
     * 회원 계정 pk
     */
    private UserAccountId id;

    /**
     * 암호화 비밀번호
     */
    private String password;

    /**
     * 비밀번호 salt
     */
    private String salt;

    /**
     * 계정 잠김 여부
     */
    @Column(nullable = false, length = 1, columnDefinition = "char default 'N'", insertable = false)
    private String isLock;

    /**
     * 비밀번호 재시도 횟수
     */
    private Integer passwordRetryCount;

    /**
     * 마지막 로그인 일시
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDateTime lastLoginDatetime;

    /**
     * 마지막 비밀번호 변경 일시
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private String lastPasswordResetDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(nullable = false, length = 1, columnDefinition = "char default 'N'", insertable = false)
    private String delYn;
}
