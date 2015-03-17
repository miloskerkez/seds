package com.kerkez.service;

import com.kerkez.model.Manager;
import com.kerkez.viewModel.ManagerViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface ManagerService {
    Manager save(Manager manager);

    List<ManagerViewModel> load();
}
