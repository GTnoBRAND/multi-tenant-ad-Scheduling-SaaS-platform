package com.example.multitenantadschedulingsaasplatform;

import org.springframework.boot.SpringApplication;

public class TestMultiTenantAdSchedulingSaaSPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.from(MultiTenantAdSchedulingSaaSPlatformApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
