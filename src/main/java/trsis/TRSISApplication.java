package trsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@ComponentScan
@EnableAutoConfiguration
@EnableWebSecurity
public class TRSISApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplicationBuilder(TRSISApplication.class).build();
        app.run(args);
    }

}
