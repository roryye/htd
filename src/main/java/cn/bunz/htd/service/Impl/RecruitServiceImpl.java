package cn.bunz.htd.service.Impl;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.repository.RecruitRepository;
import cn.bunz.htd.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    @Override
    public List<Recruit> findAll() {
        return recruitRepository.findAll();
    }
}
