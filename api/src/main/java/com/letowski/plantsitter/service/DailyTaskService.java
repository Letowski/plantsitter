package com.letowski.plantsitter.service;

import com.letowski.plantsitter.entity.enums.SystemPropertyKey;
import com.letowski.plantsitter.service.actions.Action;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class DailyTaskService {

    private final ActionService actionService;
    private final SystemPropertiesService systemPropertiesService;

    private final Set<DailyTask> dailyTasks = new HashSet<>();

    public void addTask(Action action, SystemPropertyKey systemPropertyKey) {
        DailyTask dailyTask = new DailyTask(action, systemPropertyKey);
        dailyTasks.add(dailyTask);
    }

    public void start() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::execute, 0, 60, TimeUnit.SECONDS);
    }

    private void execute() {
        dailyTasks.forEach(this::executeTask);
    }

    private void executeTask(DailyTask dailyTask) {
        Integer hour = systemPropertiesService.getInteger(dailyTask.getSystemPropertyKey());

        if (!hour.equals(LocalDateTime.now().getHour())) {
            dailyTask.setLastExecution(null);
            return;
        }

        if (dailyTask.getLastExecution() != null &&
                dailyTask.getLastExecution().isAfter(LocalDateTime.now().minusHours(1))) {
            return;
        }

        log.info("executeTask " + dailyTask.getAction().getName() + " go!");

        dailyTask.setLastExecution(LocalDateTime.now());

        actionService.execute(dailyTask.getAction());
    }

    @RequiredArgsConstructor
    @Data
    private static class DailyTask {
        private final Action action;
        private final SystemPropertyKey systemPropertyKey;
        private LocalDateTime lastExecution;
    }
}
