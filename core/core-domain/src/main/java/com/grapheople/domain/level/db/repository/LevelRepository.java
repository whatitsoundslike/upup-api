package com.grapheople.domain.level.db.repository;

import com.grapheople.domain.level.db.entity.LevelEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<LevelEntity, Long> {
    Optional<LevelEntity> findByUserId(Long userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from LevelEntity l where l.userId = :userId")
    Optional<LevelEntity> findByUserIdForUpdate(@Param("userId") Long userId);
}
