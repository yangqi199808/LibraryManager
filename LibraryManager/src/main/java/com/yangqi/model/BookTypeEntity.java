package com.yangqi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 15:22
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "book_type", schema = "library", catalog = "")
public class BookTypeEntity {
    private Integer bookType;
    private String bookName;

    @Id
    @Column(name = "book_type")
    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookTypeEntity that = (BookTypeEntity) o;
        return Objects.equals(bookType, that.bookType) &&
                Objects.equals(bookName, that.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookType, bookName);
    }

    @Override
    public String toString() {
        return "BookTypeEntity{" +
                "bookType=" + bookType +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
