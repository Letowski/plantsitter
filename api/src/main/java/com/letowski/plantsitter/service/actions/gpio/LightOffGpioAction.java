package com.letowski.plantsitter.service.actions.gpio;


import com.letowski.plantsitter.service.actions.inter.LightOffAction;
import com.letowski.plantsitter.utils.ShellUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Slf4j
@ConditionalOnProperty(prefix="plantsitter", name="action-mode", havingValue = "gpio")
@Service
public class LightOffGpioAction implements LightOffAction {

    private ShellUtils shellUtils;

    public LightOffGpioAction() {
        log.info("setUp LightOffAction");
        shellUtils.shellExec("gpio-reset " + Ports.LIGHT);
    }

    @Override
    public void executeUnsafe() {
        log.info("LightOffAction");
        shellUtils.shellExec("gpio-out " + Ports.LIGHT + " 1");
    }
}
