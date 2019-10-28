package cn.bunz.htd.repository;

import cn.bunz.htd.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

    Page<Recruit> findAll(Pageable pageable);

    Recruit findByRecruitId(Integer recruitId);

    @Query(nativeQuery = true, value = "select * from tb_recruit where ?1 >= low_salary and ?2 <= high_salary")
    Page<Recruit> findBySalary(Pageable pageable, Integer lowSalary, Integer highSalary);

}
