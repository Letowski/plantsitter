package com.letowski.plantsitter.service.actions.wifi;


import com.letowski.plantsitter.service.actions.inter.PourWaterAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@ConditionalOnProperty(prefix="plantsitter", name="action-mode", havingValue = "wifi")
@Service
public class PourWaterWifiAction implements PourWaterAction {

    @Autowired
    private McuClient client;

    public PourWaterWifiAction() {
        log.info("setUp PourWaterAction");
    }

    @Override
    public void executeUnsafe() throws Exception {
        log.info("PourWaterAction start");
        client.relay2off();
        Thread.sleep(1000L);
        client.relay2on();
        log.info("PourWaterAction end");
    }
}
