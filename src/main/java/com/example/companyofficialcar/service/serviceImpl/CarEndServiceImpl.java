package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.CarEnd;
import com.example.companyofficialcar.repository.CarEndDao;
import com.example.companyofficialcar.service.CarEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarEndServiceImpl implements CarEndService {
    private CarEndDao carEndDao;

    @Autowired
    public CarEndServiceImpl(CarEndDao carEndDao) {
        this.carEndDao = carEndDao;
    }

    @Override
    public CarEnd addCarEnd(CarEnd carEnd) {
        return carEndDao.save(carEnd);
    }

    @Override
    public void deleteCarEndById(Integer endId) {
        carEndDao.deleteById(endId);
    }

    @Override
    public CarEnd updateCarEnd(CarEnd carEnd) {
        return carEndDao.saveAndFlush(carEnd);
    }

    @Override
    public CarEnd findCarEndByRequestId(Integer requestId) {
        Optional<CarEnd> optionalCarEnd = Optional.ofNullable(carEndDao.findByRequestId(requestId));
        return optionalCarEnd.orElse(null);
    }
}
