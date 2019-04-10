package com.akelius.demographql.resolver;

import com.akelius.demographql.entity.Contract;
import com.akelius.demographql.entity.Tenant;
import com.akelius.demographql.repository.ContractRepository;
import com.akelius.demographql.repository.TenantRepository;
import com.akelius.demographql.types.ContractTenantInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class ContractMutation implements GraphQLMutationResolver {
    private ContractRepository contractRepository;
    private TenantRepository tenantRepository;

    public ContractMutation(TenantRepository tenantRepository, ContractRepository contractRepository) {
        this.tenantRepository = tenantRepository;
        this.contractRepository = contractRepository;
    }

    public Contract newContract(String title, String moveIn, Integer rent, Long tenantId) {
        Contract contract = new Contract();
        contract.setTenant(tenantRepository.findById(tenantId).get());
        contract.setTitle(title);
        contract.setMoveIn(moveIn);
        contract.setRent(rent != null ? rent : 0);

        contractRepository.save(contract);

        return contract;
    }

    public boolean deleteContract(Long id){
        contractRepository.deleteById(id);
        return true;
    }

    public Contract updateContractRent(Integer rent, Long id){
        Contract contract = contractRepository.findById(id).get();
        contract.setRent(rent);

        contractRepository.save(contract);

        return contract;
    }

    public Contract newContractAndTenant(ContractTenantInput input){
        return null;
    }

}