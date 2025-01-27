package ru.clevertec.performancemonitoring.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.performancemonitoring.aop.PerformanceMonitoringAspect;

@Configuration
@EnableConfigurationProperties(PerformanceMonitoringProperties.class)
public class PerformanceMonitoringAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "performance.monitoring", name = "enabled", havingValue = "true")
    public PerformanceMonitoringAspect performanceMonitoringAspect(PerformanceMonitoringProperties properties) {
        return new PerformanceMonitoringAspect(properties);
    }

}
