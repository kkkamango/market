package com.kkkamango.market.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 상품 정보 entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_page_history")
public class UserPageHistoryEntity {
    @Id
    private UserPageHistoryId userPageHistoryId;
}
