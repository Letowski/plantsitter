package com.letowski.plantsitter.repository;

import com.letowski.plantsitter.entity.SystemProperties;
import com.letowski.plantsitter.entity.enums.SystemPropertyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SystemPropertiesRepository extends JpaRepository<SystemProperties, SystemPropertyKey> {
}
