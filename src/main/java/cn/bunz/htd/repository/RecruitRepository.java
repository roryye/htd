package cn.bunz.htd.repository;

import cn.bunz.htd.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

    Page<Recruit> findAll(Pageable pageable);

    Recruit findByRecruitId(Integer recruitId);

}
