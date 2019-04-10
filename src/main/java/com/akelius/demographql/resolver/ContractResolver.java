package com.akelius.demographql.resolver;

import com.akelius.demographql.entity.Contract;
import com.akelius.demographql.entity.Tenant;
import com.akelius.demographql.repository.TenantRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class ContractResolver implements GraphQLResolver<Contract> {

    private TenantRepository tenantRepository;

    public ContractResolver(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public Tenant getTenant(Contract contract) {
        return tenantRepository.findById(contract.getTenant().getId()).get();
    }
}