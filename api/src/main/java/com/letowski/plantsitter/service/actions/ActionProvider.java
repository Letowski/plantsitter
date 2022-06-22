package com.letowski.plantsitter.service.actions;

import com.letowski.plantsitter.service.actions.inter.LightOffAction;
import com.letowski.plantsitter.service.actions.inter.LightOnAction;
import com.letowski.plantsitter.service.actions.inter.PourWaterAction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Getter
@Service
public class ActionProvider {
    private final LightOnAction lightOnAction;
    private final LightOffAction lightOffAction;
    private final PourWaterAction pourWaterAction;
}
