package com.yangqi.dao;

import com.yangqi.model.BookTypeEntity;
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
public class BookTypeDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(BookTypeEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(BookTypeEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    public BookTypeEntity findByID(Integer key) {
        return this.getHibernateTemplate().get(BookTypeEntity.class, key);
    }

    public List<BookTypeEntity> findAll() {
        return this.getHibernateTemplate().loadAll(BookTypeEntity.class);
    }
}
