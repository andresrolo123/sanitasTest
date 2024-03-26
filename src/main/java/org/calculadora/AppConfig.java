package org.calculadora;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    private final TracerImpl tracer;

    public AppConfig(TracerImpl tracer) {
        this.tracer = tracer;
    }

    @Bean
    public TracerImpl tracer() {
        return new TracerImpl();
    }

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(new TracerImpl());
        appConfig.tracer.trace(2);
    }
}
