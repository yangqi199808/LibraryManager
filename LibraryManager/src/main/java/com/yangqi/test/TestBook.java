package com.yangqi.test;

import com.yangqi.dao.BookDAO;
import com.yangqi.model.BookEntity;
import com.yangqi.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/2.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestBook {
    private BookDAO bookDAO;

    @Resource
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * 添加一条书籍记录
     *
     * @throws Exception
     */
    @Test
    public void addBook() throws Exception {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId("978-7-306-09641-4");
        bookEntity.setBookName("肖秀荣考研政治终极预测4套卷");
        bookEntity.setBookAuthor("肖秀荣");
        bookEntity.setBookPublish("国家开放大学出版社");
        bookEntity.setBookNum(5);
        bookEntity.setBookType(5);
        bookEntity.setBookRecord(DateUtil.getNowDate());

        bookDAO.save(bookEntity);
    }

    // @Test
    // public void testDeleteBatch() throws Exception {
    //     //删除编号为1 2 3 4的博文
    //     bookDAO.deleteBatch(new Integer[]{1, 2, 3, 4});
    //     List<BookEntity> blogs = bookDAO.findAll();
    //     for (BookEntity blog : blogs) {
    //         System.out.println(blog.getBid() + " " + blog.getTitle() + " " + blog.getContent());
    //     }
    //     System.out.println();
    // }
    //
    // @Test
    // public void testPaging() throws Exception {
    //     List<Blog> blogs = bookDAO.paging(3, 1);
    //     for (Blog blog : blogs) {
    //         System.out.println(blog.getBid() + " " + blog.getTitle() + " " + blog.getContent());
    //     }
    //     System.out.println();
    // }
    //
    // @Test
    // public void testFind()throws Exception{
    //     List<Blog> blogs = bookDAO.findByUid(2);
    //     for (Blog blog : blogs) {
    //         System.out.println(blog.getBid() + " " + blog.getTitle() + " " + blog.getContent());
    //     }
    // }
}
