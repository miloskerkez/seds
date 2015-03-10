package com.kerkez.service;

import com.kerkez.model.Bank;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface BankService {

    Bank save(Bank bank);
    List<Bank> load();
}
