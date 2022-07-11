package com.server.reactive.domain.repositories;

import com.server.reactive.domain.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {
}
