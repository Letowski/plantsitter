package com.letowski.plantsitter.config;

import com.letowski.plantsitter.service.actions.ActionProvider;
import com.letowski.plantsitter.service.DailyTaskService;
import com.letowski.plantsitter.tasks.TasksStarter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TasksConfiguration {

    @Bean
    public TasksStarter tasksStarter(DailyTaskService dailyTaskService,
                                     ActionProvider actionProvider) {
        return new TasksStarter(dailyTaskService, actionProvider);
    }
}
