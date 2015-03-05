package com.kerkez.repository;

import com.kerkez.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Repository("contractRepository")
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
