package ru.clevertec.performancemonitoring.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "performance.monitoring")
public class PerformanceMonitoringProperties {

    private boolean enabled = false;

    private long minTime = 300;

}
