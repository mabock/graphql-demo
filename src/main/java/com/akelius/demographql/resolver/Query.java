package com.akelius.demographql.resolver;

import com.akelius.demographql.entity.Contract;
import com.akelius.demographql.entity.Tenant;
import com.akelius.demographql.repository.ContractRepository;
import com.akelius.demographql.repository.TenantRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {
    private ContractRepository contractRepository;
    private TenantRepository tenantRepository;

    public Query(TenantRepository tenantRepository, ContractRepository contractRepository) {
        this.tenantRepository = tenantRepository;
        this.contractRepository = contractRepository;
    }

    public Iterable<Contract> findAllContracts() {
        return contractRepository.findAll();
    }


    public Iterable<Tenant> findAllTenants() {
        return tenantRepository.findAll();
    }
    /*public Optional<Tenant> getTenantById(Long id) {
        return tenantRepository.findById(id);
    }*/

    public long countContracts() {
        return contractRepository.count();
    }
    public long countTenants() {
        return tenantRepository.count();
    }
}