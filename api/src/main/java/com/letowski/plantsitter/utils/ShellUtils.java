package com.letowski.plantsitter.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@Service
public class ShellUtils {

    public String shellExec(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            StringBuilder sb = new StringBuilder();
            int code = p.waitFor();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            log.info("shellExec = " + command + " code = " + code);
            log.info(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
