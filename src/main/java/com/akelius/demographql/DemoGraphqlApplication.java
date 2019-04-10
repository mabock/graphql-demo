package com.akelius.demographql;

import com.akelius.demographql.repository.ContractRepository;
import com.akelius.demographql.repository.TenantRepository;
import com.akelius.demographql.resolver.ContractResolver;
import com.akelius.demographql.resolver.TenantMutation;
import com.akelius.demographql.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class DemoGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphqlApplication.class, args);
    }

    @Bean

    public ContractResolver tenantResolver(TenantRepository tenantRepository) {
        return new ContractResolver(tenantRepository);
    }

    @Bean
    public Query query(TenantRepository tenantRepository, ContractRepository contractRepository) {
        return new Query(tenantRepository, contractRepository);
    }

}

