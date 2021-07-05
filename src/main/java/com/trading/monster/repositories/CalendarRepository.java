package com.trading.monster.repositories;

import com.trading.monster.domain.CalendarDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarDay, String> {
}
