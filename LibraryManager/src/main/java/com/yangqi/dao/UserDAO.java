package com.yangqi.dao;

import com.yangqi.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 * BlogDAO
 */
@Repository
@Transactional
public class UserDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(UserEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(UserEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    public UserEntity findByID(String key) {
        return this.getHibernateTemplate().get(UserEntity.class, key);
    }

    public List<UserEntity> findAll() {
        return this.getHibernateTemplate().loadAll(UserEntity.class);
    }
}