package com.yangqi.dao;

import com.yangqi.model.BorrowEntity;
import com.yangqi.model.BorrowEntityPK;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 * UserDAO
 */
@Repository
@Transactional
public class BorrowDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(BorrowEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(BorrowEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    /**
     * 根据联合主键进行查询
     *
     * @param key1 学生学号
     * @param key2 书籍ISBN
     * @return Borrow的联合主键
     */
    public BorrowEntity findByID(String key1, String key2) {
        BorrowEntityPK borrowEntityPK = new BorrowEntityPK();
        borrowEntityPK.setStuId(key1);
        borrowEntityPK.setBookId(key2);
        return this.getHibernateTemplate().get(BorrowEntity.class, borrowEntityPK);
    }

    public List<BorrowEntity> findAll() {
        return this.getHibernateTemplate().loadAll(BorrowEntity.class);
    }

}
