package com.letowski.plantsitter.service.actions.gpio;


import com.letowski.plantsitter.service.actions.inter.LightOnAction;
import com.letowski.plantsitter.utils.ShellUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@ConditionalOnProperty(prefix="plantsitter", name="action-mode", havingValue = "gpio")
@Service
public class LightOnGpioAction implements LightOnAction {

    private ShellUtils shellUtils;

    public LightOnGpioAction() {
        log.info("setUp LightOnAction");
        shellUtils.shellExec("gpio-reset " + Ports.LIGHT);
    }

    @Override
    public void executeUnsafe() {
        log.info("LightOnAction");
        shellUtils.shellExec("gpio-out " + Ports.LIGHT + " 0");
    }
}
