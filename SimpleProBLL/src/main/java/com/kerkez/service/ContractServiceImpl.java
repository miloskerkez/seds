package com.kerkez.service;

import com.kerkez.model.Contract;
import com.kerkez.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Qualifier("contractRepository")
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }
}
