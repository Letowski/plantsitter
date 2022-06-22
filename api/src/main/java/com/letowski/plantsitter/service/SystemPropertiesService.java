package com.letowski.plantsitter.service;

import com.letowski.plantsitter.entity.SystemProperties;
import com.letowski.plantsitter.entity.enums.SystemPropertyKey;
import com.letowski.plantsitter.repository.SystemPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SystemPropertiesService {

    private final SystemPropertiesRepository systemPropertiesRepository;

    public Integer getInteger(SystemPropertyKey key) {
        return Integer.parseInt(
                systemPropertiesRepository.findById(key)
                        .map(SystemProperties::getValue)
                        .orElse(key.getDefaultValue()));
    }

    public String getString(SystemPropertyKey key) {
        return systemPropertiesRepository.findById(key)
                .map(SystemProperties::getValue)
                .orElse(key.getDefaultValue());
    }
}
