package com.letowski.plantsitter.controller;

import com.letowski.plantsitter.entity.ActionLog;
import com.letowski.plantsitter.entity.enums.ActionType;
import com.letowski.plantsitter.service.ActionLogService;
import com.letowski.plantsitter.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/action")
public class ActionController {

    private final ActionLogService actionLogService;
    private final ActionService actionService;

    @PostMapping ("/make")
    public ActionLog makeAction(@RequestParam ActionType type) {
        return actionService.execute(type);
    }

    @GetMapping("/latest")
    public List<ActionLog> listAction() {
        return actionLogService.listAction();
    }

    @GetMapping("/status/light")
    public ActionLog getStatusLight() {
        return actionLogService.getStatusLight();
    }

    @GetMapping("/status/pour")
    public ActionLog getStatusPour() {
        return actionLogService.getStatusPour();
    }
}
