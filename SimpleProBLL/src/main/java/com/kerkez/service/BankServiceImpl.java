package com.kerkez.service;

import com.kerkez.model.Bank;
import com.kerkez.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("bankService")
public class BankServiceImpl implements BankService {

    @Qualifier("bankRepository")
    @Autowired
    private BankRepository bankRepository;

    @Override
    @Transactional
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public List<Bank> load() {
        List<Bank> banks = bankRepository.findAll();
        //this is where i stop last time!!!! Convert this in view model and send back
        return banks;
    }
}
