package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.CarRequest;
import com.example.companyofficialcar.repository.CarRequestDao;
import com.example.companyofficialcar.service.CarRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRequestServiceImpl implements CarRequestService {
    private CarRequestDao carRequestDao;

    @Autowired
    public CarRequestServiceImpl(CarRequestDao carRequestDao) {
        this.carRequestDao = carRequestDao;
    }
    @Override
    public CarRequest addCarRequest(CarRequest carRequest) {
        return carRequestDao.save(carRequest);
    }

    @Override
    public void deleteCarRequestById(Integer requestId) {
        carRequestDao.deleteById(requestId);
    }

    @Override
    public CarRequest updateCarRequest(CarRequest carRequest) {
        return carRequestDao.saveAndFlush(carRequest);
    }

    @Override
    public List<CarRequest> findCarRequestsByApplicantId(Integer applicantId) {
        return carRequestDao.findByApplicantId(applicantId);
    }

    @Override
    public List<CarRequest> findCarRequestsByStatus(String status) {
        return carRequestDao.findByStatus(status);
    }

    @Override
    public List<CarRequest> getAllCarRequest() {
        return carRequestDao.findAll();
    }

    @Override
    public List<Object[]> getCarRequestsWithApplicantUsername() {
        return carRequestDao.findCarRequestsWithApplicantUsername();
    }

}
