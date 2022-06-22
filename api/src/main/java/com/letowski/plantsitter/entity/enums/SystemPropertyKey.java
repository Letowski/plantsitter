package com.letowski.plantsitter.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SystemPropertyKey {
    LIGHT_HOUR_START("7"),
    LIGHT_HOUR_END("1");

    private final String defaultValue;
}
