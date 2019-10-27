package cn.bunz.htd.repository;

import cn.bunz.htd.entity.Recruit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecruitRepositoryTest {

    @Autowired
    private RecruitRepository recruitRepository;

    @Test
    void findAll() {
        List<Recruit> recruitList = recruitRepository.findAll();
        for (Recruit recruit : recruitList) {
            System.out.println(recruit);
        }
        assertEquals(1, recruitList.size());
    }

    @Test
    void findByRecruitId() {
        Recruit recruit = recruitRepository.findByRecruitId(1);
        System.out.println(recruit);
    }
}