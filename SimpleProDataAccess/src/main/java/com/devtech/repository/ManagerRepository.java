package com.devtech.repository;

import com.devtech.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Repository("managerRepository")
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
