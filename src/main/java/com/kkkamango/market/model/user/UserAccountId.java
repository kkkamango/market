package com.kkkamango.market.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 회원 계정 pk 모델
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserAccountId implements Serializable {

    /**
     * 회원ID
     */
    private String userId;
    /**
     * 계정타입
     */
    private String signupType;
    /**
     * 회원 계정
     */
    private String account;
}
