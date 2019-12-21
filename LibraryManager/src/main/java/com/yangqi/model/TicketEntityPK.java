package com.yangqi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 15:22
 */
public class TicketEntityPK implements Serializable {
    private String stuId;
    private String bookId;

    @Column(name = "stu_id")
    @Id
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Column(name = "book_id")
    @Id
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketEntityPK that = (TicketEntityPK) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, bookId);
    }

    @Override
    public String toString() {
        return "TicketEntityPK{" +
                "stuId='" + stuId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
