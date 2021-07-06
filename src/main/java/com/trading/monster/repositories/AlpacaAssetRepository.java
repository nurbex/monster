package com.trading.monster.repositories;

import com.trading.monster.domain.AlpacaAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlpacaAssetRepository extends JpaRepository<AlpacaAsset, String> {
}
