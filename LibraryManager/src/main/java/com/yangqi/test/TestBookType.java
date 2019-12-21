package com.yangqi.test;

import com.yangqi.dao.BookTypeDAO;
import com.yangqi.model.BookTypeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestBookType {
    private BookTypeDAO bookTypeDAO;

    @Resource
    public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }

    /**
     * 添加一条书籍类型记录
     */
    @Test
    public void saveBookType() {
        BookTypeEntity bookTypeEntity = new BookTypeEntity();
        bookTypeEntity.setBookType(4);
        bookTypeEntity.setBookName("人文科学类");

        bookTypeDAO.save(bookTypeEntity);
    }

    /**
     * 删除一条书籍类型记录
     */
    @Test
    public void deleteBookType() {
        BookTypeEntity bookTypeEntity = bookTypeDAO.findByID(4);
        bookTypeDAO.delete(bookTypeEntity);
    }

    /**
     * 查询所有的书籍类型记录
     */
    @Test
    public void findAllBookType() {
        List<BookTypeEntity> bookTypeEntityList = bookTypeDAO.findAll();
        for (BookTypeEntity bookTypeEntity : bookTypeEntityList) {
            System.out.println(bookTypeEntity);
        }
    }
}
