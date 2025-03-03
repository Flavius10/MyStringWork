package config;

import aspects.LoggingAspects;
import aspects.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "services")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspects loggingAspects(){
        return new LoggingAspects();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }
}
