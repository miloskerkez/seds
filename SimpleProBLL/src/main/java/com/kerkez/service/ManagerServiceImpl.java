package com.kerkez.service;

import com.kerkez.model.Manager;
import com.kerkez.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Qualifier("managerRepository")
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> load() {
        return managerRepository.findAll();
    }
}
