package com.yangqi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 18:50
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "user", schema = "library", catalog = "")
public class UserEntity {
    private String stuId;
    private String password;

    @Id
    @Column(name = "stu_id")
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, password);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "stuId='" + stuId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
