package com.letowski.plantsitter.service.actions.wifi;


import com.letowski.plantsitter.service.actions.inter.LightOnAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@ConditionalOnProperty(prefix="plantsitter", name="action-mode", havingValue = "wifi")
@Service
public class LightOnWifiAction implements LightOnAction {

    @Autowired
    private McuClient client;

    public LightOnWifiAction() {
        log.info("setUp LightOffAction");
    }

    @Override
    public void executeUnsafe() {
        log.info("LightOffAction");
        client.relay1off();
    }
}
