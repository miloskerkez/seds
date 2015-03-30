package com.kerkez.service;

import com.kerkez.model.Manager;
import com.kerkez.viewModel.ManagerViewModel;
import com.kerkez.viewModel.UpdateManagerViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface ManagerService {
    Manager save(Manager manager);

    List<ManagerViewModel> load();

    void delete(Long m);

    Manager getOne(Long id);

    void update(UpdateManagerViewModel updateManagerViewModel);
}
