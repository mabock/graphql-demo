package com.akelius.demographql.resolver;

import com.akelius.demographql.entity.Contract;
import com.akelius.demographql.entity.Tenant;
import com.akelius.demographql.repository.ContractRepository;
import com.akelius.demographql.repository.TenantRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantMutation implements GraphQLMutationResolver {
    private ContractRepository contractRepository;
    private TenantRepository tenantRepository;

    public TenantMutation(TenantRepository tenantRepository, ContractRepository contractRepository) {
        this.tenantRepository = tenantRepository;
        this.contractRepository = contractRepository;
    }

    public Tenant newTenant(String firstName, String lastName) {
        Tenant tenant = new Tenant();
        tenant.setFirstName(firstName);
        tenant.setLastName(lastName);

        tenantRepository.save(tenant);

        return tenant;
    }

}