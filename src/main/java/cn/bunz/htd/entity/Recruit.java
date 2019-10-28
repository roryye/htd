package cn.bunz.htd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_recruit")
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recruitId;

    private String recruitTitle;

    private String enterpriseName;

    private Integer eye;

    private Integer ear;

    private Integer mouth;

    private Integer hand;

    private Integer leg;

    private String education;

    private String experience;

    private Integer numberOfRecruits;

    private String jobType;

    private Date createDate;

    private Date effectiveDate;

    private Integer age;

    private String gender;

    private Integer lowSalary;

    private Integer highSalary;

    private String jobDesc;

    private String address;


}
