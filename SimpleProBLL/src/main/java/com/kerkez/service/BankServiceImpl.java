package com.kerkez.service;

import com.kerkez.model.Bank;
import com.kerkez.model.Manager;
import com.kerkez.model.Player;
import com.kerkez.repository.BankRepository;
import com.kerkez.repository.ManagerRepository;
import com.kerkez.viewModel.BankViewModel;
import com.kerkez.viewModel.UpdateBankViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("bankService")
public class BankServiceImpl implements BankService {

    @Qualifier("bankRepository")
    @Autowired
    private BankRepository bankRepository;

    @Qualifier("managerRepository")
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    @Transactional
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public List<BankViewModel> load() {
        List<Bank> banks = bankRepository.findAll();
        List<BankViewModel> banksvm = new ArrayList<BankViewModel>();
        for(Bank b: banks){
            BankViewModel bvm = new BankViewModel(b);
            banksvm.add(bvm);
        }
        return banksvm;
    }


    @Override
    public void delete(Long d) {
        Bank bank = bankRepository.findOne(d);
        List<Manager> managerList = bank.getBankManagers();
        for (Manager m:managerList){
            Manager manager = managerRepository.findOne(m.getManagerId());
            Bank bank1 = bankRepository.findOne((long) 1);
            manager.setManagerBank(bank1);
            managerRepository.save(manager);
        }
        bankRepository.delete(d);
    }

    @Override
    public Bank getOne(Long id) {
        return bankRepository.findOne(id);
    }

    @Override
    public void update(UpdateBankViewModel updateBankViewModel) {
        Bank bank = bankRepository.findOne(updateBankViewModel.getUbvmId());
        bank.setBankName(updateBankViewModel.getUbvmName());
        bankRepository.save(bank);
    }
}
