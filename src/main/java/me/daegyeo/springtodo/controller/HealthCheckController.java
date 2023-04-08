package me.daegyeo.springtodo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public HealthCheckResponse healthCheck() {
        return new HealthCheckResponse(true);
    }
}

record HealthCheckResponse(boolean result) {
}