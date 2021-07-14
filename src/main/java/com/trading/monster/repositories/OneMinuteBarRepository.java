package com.trading.monster.repositories;

import com.trading.monster.domain.OneMinuteBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OneMinuteBarRepository extends JpaRepository<OneMinuteBar, String> {
}
