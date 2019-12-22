package com.yangqi.dao;

import com.yangqi.model.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
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
public class BookDAO extends HibernateDaoSupport {
    @Resource
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(BookEntity value) {
        this.getHibernateTemplate().saveOrUpdate(value);
    }

    public void delete(BookEntity value) {
        this.getHibernateTemplate().delete(value);
    }

    public BookEntity findById(String key) {
        return this.getHibernateTemplate().get(BookEntity.class, key);
    }

    public List<BookEntity> findAll() {
        return this.getHibernateTemplate().loadAll(BookEntity.class);
    }

    /**
     * 批量删除
     *
     * @param flag 删除的标号
     */
    public void deleteBatch(Integer[] flag) {
        String hql = "delete BookEntity where id in (:bid) ";
        this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            @Transactional
            public Object doInHibernate(Session session) {
                Query query = session.createQuery(hql);
                query.setParameterList("bid", flag);
                return query.executeUpdate();
            }
        });
    }

    /**
     * 分页
     * @param limit       每页分几个条目
     * @param currentPage 当前第几页
     * @return 返回分页后的n个Blog对象
     */
    public List<BookEntity> paging(int limit, int currentPage) {
        return this.getHibernateTemplate().execute(new HibernateCallback<List<BookEntity>>() {
            @Override
            @Transactional
            public List<BookEntity> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from BookEntity ");
                query.setFirstResult((limit) * (currentPage - 1));
                query.setMaxResults(limit);
                return query.list();
            }
        });
    }
}