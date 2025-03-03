package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import proxies.CommentNotificationProxy;

@Configuration
@ComponentScan(basePackages = {"proxies", "repositories", "services"})
public class ProjectConfig {

}
