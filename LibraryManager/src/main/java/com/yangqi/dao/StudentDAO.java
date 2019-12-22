package com.yangqi.dao;

import com.yangqi.model.StudentEntity;
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
public class StudentDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(StudentEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(StudentEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    public StudentEntity findById(String key) {
        return this.getHibernateTemplate().get(StudentEntity.class, key);
    }

    public List<StudentEntity> findAll() {
        return this.getHibernateTemplate().loadAll(StudentEntity.class);
    }
}