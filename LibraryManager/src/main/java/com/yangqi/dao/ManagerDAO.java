package com.yangqi.dao;

import com.yangqi.model.ManagerEntity;
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
public class ManagerDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(ManagerEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(ManagerEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    public ManagerEntity findByID(Integer key) {
        return this.getHibernateTemplate().get(ManagerEntity.class, key);
    }

    public List<ManagerEntity> findAll() {
        return this.getHibernateTemplate().loadAll(ManagerEntity.class);
    }
}
