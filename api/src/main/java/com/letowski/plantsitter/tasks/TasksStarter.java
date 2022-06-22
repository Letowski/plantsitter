package com.letowski.plantsitter.tasks;

import com.letowski.plantsitter.service.actions.ActionProvider;
import com.letowski.plantsitter.entity.enums.SystemPropertyKey;
import com.letowski.plantsitter.service.DailyTaskService;

public class TasksStarter {


    private final DailyTaskService dailyTaskService;
    private final ActionProvider actionProvider;

    public TasksStarter(DailyTaskService dailyTaskService, ActionProvider actionProvider) {
        this.dailyTaskService = dailyTaskService;
        this.actionProvider = actionProvider;

        dailyTaskService.addTask(actionProvider.getLightOnAction(), SystemPropertyKey.LIGHT_HOUR_START);
        dailyTaskService.addTask(actionProvider.getLightOffAction(), SystemPropertyKey.LIGHT_HOUR_END);

        dailyTaskService.start();
    }
}
