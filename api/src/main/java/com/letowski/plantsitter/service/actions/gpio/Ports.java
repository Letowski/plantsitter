package com.letowski.plantsitter.service.actions.gpio;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Ports {
    LIGHT(10),
    PUMP(21);

    private final Integer port;

    @Override
    public String toString() {
        return port.toString();
    }
}
