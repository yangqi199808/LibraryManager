package com.yangqi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 15:22
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "student", schema = "library", catalog = "")
public class StudentEntity {
    private String stuId;
    private String stuName;
    private String stuSex;
    private Integer stuAge;
    private String stuPro;
    private String stuGrade;
    private Integer stuIntegrity;

    @Id
    @Column(name = "stu_id")
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_name")
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "stu_sex")
    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    @Basic
    @Column(name = "stu_age")
    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    @Basic
    @Column(name = "stu_pro")
    public String getStuPro() {
        return stuPro;
    }

    public void setStuPro(String stuPro) {
        this.stuPro = stuPro;
    }

    @Basic
    @Column(name = "stu_grade")
    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Basic
    @Column(name = "stu_integrity")
    public Integer getStuIntegrity() {
        return stuIntegrity;
    }

    public void setStuIntegrity(Integer stuIntegrity) {
        this.stuIntegrity = stuIntegrity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(stuName, that.stuName) &&
                Objects.equals(stuSex, that.stuSex) &&
                Objects.equals(stuAge, that.stuAge) &&
                Objects.equals(stuPro, that.stuPro) &&
                Objects.equals(stuGrade, that.stuGrade) &&
                Objects.equals(stuIntegrity, that.stuIntegrity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, stuSex, stuAge, stuPro, stuGrade, stuIntegrity);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge=" + stuAge +
                ", stuPro='" + stuPro + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", stuIntegrity=" + stuIntegrity +
                '}';
    }
}
