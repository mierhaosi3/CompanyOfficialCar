package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.CarEnd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEndDao extends JpaRepository<CarEnd, Integer> {
    // 添加用车结束记录
    CarEnd save(CarEnd carEnd);

    // 删除用车结束记录
    void deleteById(Integer endId);

    // 更新用车结束记录信息
    CarEnd saveAndFlush(CarEnd carEnd);

    // 根据申请ID查找用车结束记录
    CarEnd findByRequestId(Integer requestId);
}
