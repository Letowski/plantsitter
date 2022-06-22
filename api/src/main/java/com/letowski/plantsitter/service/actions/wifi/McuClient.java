package com.letowski.plantsitter.service.actions.wifi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "mcu",
        url = "${plantsitter.wifi.mcu-host}"
)
public interface McuClient {

    @GetMapping("/relay2off")
    void relay2off();

    @GetMapping("/relay2on")
    void relay2on();

    @GetMapping("/relay1on")
    void relay1on();

    @GetMapping("/relay1off")
    void relay1off();

}
