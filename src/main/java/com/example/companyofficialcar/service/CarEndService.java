package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.CarEnd;

public interface CarEndService {
    CarEnd addCarEnd(CarEnd carEnd);

    void deleteCarEndById(Integer endId);

    CarEnd updateCarEnd(CarEnd carEnd);

    CarEnd findCarEndByRequestId(Integer requestId);
}
