package com.letowski.plantsitter.service;

import com.letowski.plantsitter.entity.ActionLog;
import com.letowski.plantsitter.entity.enums.ActionType;
import com.letowski.plantsitter.service.actions.ActionProvider;
import com.letowski.plantsitter.repository.ActionLogRepository;
import com.letowski.plantsitter.service.actions.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionLogRepository actionLogRepository;
    private final ActionProvider actionProvider;

    public ActionLog execute(Action action) {
        ActionLog actionLog = new ActionLog();
        actionLog.setType(action.getName());
        actionLogRepository.save(actionLog);
        new Thread(action::execute).start();
        log.info("task " + action.getName() + " executed");
        return actionLog;
    }

    public ActionLog execute(ActionType type) {
        switch (type) {
            case LIGHT_ON : {
                return execute(actionProvider.getLightOnAction());
            }
            case LIGHT_OFF: {
                return execute(actionProvider.getLightOffAction());
            }
            case POUR_WATER: {
                return execute(actionProvider.getPourWaterAction());
            }
            default: {
                throw new RuntimeException("ActionService.execute");
            }
        }
    }
}
