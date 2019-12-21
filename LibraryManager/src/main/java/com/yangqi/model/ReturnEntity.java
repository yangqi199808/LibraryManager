package com.yangqi.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 15:22
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "return", schema = "library", catalog = "")
@IdClass(ReturnEntityPK.class)
public class ReturnEntity {
    private String stuId;
    private String bookId;
    private Timestamp borrowDate;
    private Timestamp returnDate;

    @Id
    @Column(name = "stu_id")
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Id
    @Column(name = "book_id")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "borrow_date")
    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Basic
    @Column(name = "return_date")
    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReturnEntity that = (ReturnEntity) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(borrowDate, that.borrowDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, bookId, borrowDate, returnDate);
    }

    @Override
    public String toString() {
        return "ReturnEntity{" +
                "stuId='" + stuId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
