package com.letowski.plantsitter.service.actions.gpio;


import com.letowski.plantsitter.service.actions.inter.PourWaterAction;
import com.letowski.plantsitter.utils.ShellUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@ConditionalOnProperty(prefix="plantsitter", name="action-mode", havingValue = "gpio")
@Service
public class PourWaterGpioAction implements PourWaterAction {

    private ShellUtils shellUtils;

    public PourWaterGpioAction() {
        log.info("setUp PourWaterAction");
        shellUtils.shellExec("gpio-reset " + Ports.PUMP);
    }

    @Override
    public void executeUnsafe() throws Exception {
        log.info("PourWaterAction start");
        shellUtils.shellExec("gpio-out " + Ports.PUMP + " 0");
        Thread.sleep(1000L);
        shellUtils.shellExec("gpio-out " + Ports.PUMP + " 1");
        log.info("PourWaterAction end");
    }
}
