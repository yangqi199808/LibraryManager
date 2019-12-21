package com.yangqi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xiaoer
 * @date 2019/12/21 15:22
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "ticket", schema = "library", catalog = "")
@IdClass(TicketEntityPK.class)
public class TicketEntity {
    private String stuId;
    private String bookId;
    private Integer overDate;
    private Double ticketFee;

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
    @Column(name = "over_date")
    public Integer getOverDate() {
        return overDate;
    }

    public void setOverDate(Integer overDate) {
        this.overDate = overDate;
    }

    @Basic
    @Column(name = "ticket_fee")
    public Double getTicketFee() {
        return ticketFee;
    }

    public void setTicketFee(Double ticketFee) {
        this.ticketFee = ticketFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(overDate, that.overDate) &&
                Objects.equals(ticketFee, that.ticketFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, bookId, overDate, ticketFee);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "stuId='" + stuId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", overDate=" + overDate +
                ", ticketFee=" + ticketFee +
                '}';
    }
}
