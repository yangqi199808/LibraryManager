package com.yangqi.test;

import com.yangqi.dao.BorrowDAO;
import com.yangqi.model.BorrowEntity;
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
public class TestBorrow {
    private BorrowDAO borrowDAO;

    @Resource
    public void setBorrowDAO(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    /**
     * 添加一条借阅记录
     */
    @Test
    public void addBorrow() {
        BorrowEntity borrowEntity = new BorrowEntity();
        borrowEntity.setStuId("1618014058");
        borrowEntity.setBookId("978-7-304-09601-4");
        borrowEntity.setBorrowDate(DateUtil.getNowDate());
        borrowEntity.setExpectReturnDate(DateUtil.afterThirtyDays());

        borrowDAO.save(borrowEntity);
    }

    /**
     * 删除一条借阅记录
     */
    @Test
    public void deleteBorrow() {
        BorrowEntity borrowEntity = borrowDAO.findByID("1618014058", "978-7-304-09601-4");
        borrowDAO.delete(borrowEntity);
    }
}
