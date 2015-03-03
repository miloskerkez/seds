package com.devtech.repository;

import com.devtech.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */

@Repository("bankRepository")
public interface BankRepository extends JpaRepository<Bank, Long> {
}
