package config;

import aspects.LoggingAspect;
import aspects.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "services")
public class ProjectConfig {

    @Bean
    public LoggingAspect aspect() { return new LoggingAspect(); }

    @Bean
    public SecurityAspect securityAspect() { return new SecurityAspect(); }
}
