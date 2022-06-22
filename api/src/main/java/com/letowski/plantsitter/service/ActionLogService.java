package com.letowski.plantsitter.service;

import com.letowski.plantsitter.entity.ActionLog;
import com.letowski.plantsitter.repository.ActionLogRepository;
import com.letowski.plantsitter.service.actions.ActionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionLogService {

    private final ActionProvider actionProvider;
    private final ActionLogRepository actionLogRepository;

    public List<ActionLog> listAction() {
        return actionLogRepository.findAllByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime.now().minusDays(1));
    }

    public ActionLog getStatusLight() {
        return actionLogRepository.findFirstByTypeInOrderByCreatedAtDesc(List.of(
                actionProvider.getLightOnAction().getName(),
                actionProvider.getLightOffAction().getName()))
                .orElseGet(() -> {
                    ActionLog actionLog = new ActionLog();
                    actionLog.setType(actionProvider.getLightOffAction().getName());
                    return actionLog;
                });
    }

    public ActionLog getStatusPour() {
        return actionLogRepository.findFirstByTypeInOrderByCreatedAtDesc(List.of(
                actionProvider.getPourWaterAction().getName()
        ))
                .orElseGet(() -> {
                    ActionLog actionLog = new ActionLog();
                    actionLog.setType(actionProvider.getPourWaterAction().getName());
                    return actionLog;
                });
    }
}
