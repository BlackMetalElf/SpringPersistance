package com.server.reactive.domain.repositories;

import com.server.reactive.domain.entities.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractTypeRepository extends JpaRepository<ContractType,Short> {
}
