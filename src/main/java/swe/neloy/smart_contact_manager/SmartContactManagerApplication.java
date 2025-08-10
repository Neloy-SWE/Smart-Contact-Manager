package swe.neloy.smart_contact_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SmartContactManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartContactManagerApplication.class, args);
    }

}
