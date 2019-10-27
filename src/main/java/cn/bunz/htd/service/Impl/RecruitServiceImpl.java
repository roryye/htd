package cn.bunz.htd.service.Impl;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.repository.RecruitRepository;
import cn.bunz.htd.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    @Override
    public Page<Recruit> findAll(Pageable pageable) {
        return recruitRepository.findAll(pageable);
    }

    @Override
    public Recruit findByRecruitId(Integer recruitId) {
        return recruitRepository.findByRecruitId(recruitId);
    }
}
