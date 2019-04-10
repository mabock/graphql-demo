package com.akelius.demographql.repository;

import com.akelius.demographql.entity.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Long> {

}
