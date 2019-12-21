package com.yangqi.test;

import com.yangqi.dao.ManagerDAO;
import com.yangqi.model.ManagerEntity;
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
public class TestManager {
    private ManagerDAO managerDAO;

    @Resource
    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    /**
     * 添加一条书籍记录
     *
     * @throws Exception
     */
    @Test
    public void addManager() throws Exception {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setManagerId("admin");
        managerEntity.setManagerName("张三");
        managerEntity.setManagerAge(20);
        managerEntity.setManagerPhone("1776477677");
        managerEntity.setManagerPassword("admin");
        managerDAO.save(managerEntity);
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
