package com.vnightray.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.vnightray", exclude = { DataSourceAutoConfiguration.class })
public class VnightrayAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnightrayAdminApplication.class, args);
        System.out.println("The ACGNs Management tool is running successfully!");
    }

}
