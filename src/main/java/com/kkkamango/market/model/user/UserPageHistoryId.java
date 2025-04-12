package com.kkkamango.market.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 상품 정보 pk 모델
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserPageHistoryId implements Serializable {
    /**
     * 회원ID
     */
    private String user_id;
    /**
     * 페이지
     */
    private String page;
    /**
     * 접근 일시
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime access_timestamp;
}
