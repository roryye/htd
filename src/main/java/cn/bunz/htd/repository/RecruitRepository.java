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

    //or后面是为了查找薪水“不限”的数据
    @Query(nativeQuery = true, value = "select * from tb_recruit where (?1 >= low_salary and ?2 <= high_salary) or (low_salary >= ?1 &&  high_salary <= ?2)")
    Page<Recruit> findBySalary(Pageable pageable, Integer lowSalary, Integer highSalary);

    @Query(nativeQuery = true, value = "select * from tb_recruit where education like ?1")
    Page<Recruit> findByEducation(Pageable pageable, String education);

    @Query(nativeQuery = true, value = "select * from tb_recruit where experience like ?1")
    Page<Recruit> findByExperience(Pageable pageable, String experience);

    @Query(nativeQuery = true, value = "select * from tb_recruit where recruit_title like %?1%")
    Page<Recruit> findBySearchText(Pageable pageable, String searchText);

}
