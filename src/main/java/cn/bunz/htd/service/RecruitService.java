package cn.bunz.htd.service;

import cn.bunz.htd.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RecruitService {
    Page<Recruit> findAll(Pageable pageable);

    Recruit findByRecruitId(Integer recruitId);

    Page<Recruit> findBySalary(Pageable pageable, Integer lowSalary, Integer highSalary);
}
