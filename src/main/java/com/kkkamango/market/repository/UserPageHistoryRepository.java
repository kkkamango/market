package com.kkkamango.market.repository;

import com.kkkamango.market.model.user.UserPageHistoryEntity;
import com.kkkamango.market.model.user.UserPageHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPageHistoryRepository extends JpaRepository<UserPageHistoryEntity, UserPageHistoryId> {

}
