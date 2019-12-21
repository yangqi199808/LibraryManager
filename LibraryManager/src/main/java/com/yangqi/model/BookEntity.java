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
@Table(name = "book", schema = "library", catalog = "")
public class BookEntity {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String bookTranslator;
    private String bookPublish;
    private Integer bookNum;
    private Integer bookType;
    private Timestamp bookRecord;

    @Id
    @Column(name = "book_id")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "book_author")
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Basic
    @Column(name = "book_translator")
    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator;
    }

    @Basic
    @Column(name = "book_publish")
    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    @Basic
    @Column(name = "book_num")
    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    @Basic
    @Column(name = "book_type")
    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    @Basic
    @Column(name = "book_record")
    public Timestamp getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(Timestamp bookRecord) {
        this.bookRecord = bookRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookEntity that = (BookEntity) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(bookAuthor, that.bookAuthor) &&
                Objects.equals(bookTranslator, that.bookTranslator) &&
                Objects.equals(bookPublish, that.bookPublish) &&
                Objects.equals(bookNum, that.bookNum) &&
                Objects.equals(bookType, that.bookType) &&
                Objects.equals(bookRecord, that.bookRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookAuthor, bookTranslator, bookPublish, bookNum, bookType, bookRecord);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTranslator='" + bookTranslator + '\'' +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookNum=" + bookNum +
                ", bookType=" + bookType +
                ", bookRecord=" + bookRecord +
                '}';
    }
}
