package com.bondif.microservices.tp1.companyservice;

import com.bondif.microservices.tp1.companyservice.dao.CompanyRepository;
import com.bondif.microservices.tp1.companyservice.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class CompanyserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompanyRepository companyRepository) {
        return args -> {
            Stream.of("A", "B", "C").forEach(name -> {
                companyRepository.save(new Company(null, name, 100 + (Math.random() * 900)));
            });

            companyRepository.findAll().forEach(System.out::println);
        };
    }
}
