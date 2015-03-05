package com.kerkez.repository;

import com.kerkez.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */

@Repository("bankRepository")
public interface BankRepository extends JpaRepository<Bank, Long> {
}
