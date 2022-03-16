package com.urbancompany.uber.services;

import com.urbancompany.uber.database.CabsStorage;
import com.urbancompany.uber.models.Cab;

public class CabServiceImpl implements CabService{
    @Override
    public void registerCab(Cab cab) {
        CabsStorage.addCab(cab);
    }
}
