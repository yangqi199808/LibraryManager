package com.yangqi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 23:22
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "manager", schema = "library", catalog = "")
public class ManagerEntity {
    private String managerId;
    private String managerName;
    private Integer managerAge;
    private String managerPhone;
    private String managerPassword;

    @Id
    @Column(name = "manager_id")
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "manager_name")
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Basic
    @Column(name = "manager_age")
    public Integer getManagerAge() {
        return managerAge;
    }

    public void setManagerAge(Integer managerAge) {
        this.managerAge = managerAge;
    }

    @Basic
    @Column(name = "manager_phone")
    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    @Basic
    @Column(name = "manager_password")
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManagerEntity that = (ManagerEntity) o;
        return Objects.equals(managerId, that.managerId) &&
                Objects.equals(managerName, that.managerName) &&
                Objects.equals(managerAge, that.managerAge) &&
                Objects.equals(managerPhone, that.managerPhone) &&
                Objects.equals(managerPassword, that.managerPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, managerName, managerAge, managerPhone, managerPassword);
    }

    @Override
    public String toString() {
        return "ManagerEntity{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerAge=" + managerAge +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                '}';
    }
}
