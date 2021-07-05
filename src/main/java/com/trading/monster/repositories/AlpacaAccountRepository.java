package com.trading.monster.repositories;

import com.trading.monster.domain.AlpacaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlpacaAccountRepository extends JpaRepository<AlpacaAccount, String> {
}
