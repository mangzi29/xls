package com.xls.xc.xpy.common;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.common
 * @ClassName: BaseDaoHibernate4
 * @Description: Hibernate4 BaseDao
 * 在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,
 * 加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
 * @Author: SkyChen
 * @Create: 2020-03-31 00:26
 * @Version: v1.0
 **/
@Transactional(rollbackFor = {Exception.class})
public class BaseDaoHibernate4<T> {
    protected final Logger logger = Logger.getLogger(getClass());

    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * 查询实体
     * @param entityClass
     * @param id
     * @return
     */
    public T getEntity(Class<T> entityClass, Serializable id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass,id);
    }

    /**
     * 保存实体
     * @param entity
     * @return
     */
    public  Serializable saveEntity(T entity) {
       return sessionFactory.getCurrentSession().save(entity);
    }

    /**
     * 更新实体
     * @param entity
     */
    public void updateEntity(T entity) {
        sessionFactory.getCurrentSession().update(entity);

    }

    /**
     * 删除实体
     * @param entity
     */
    public void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    /**
     * 提交事务
     */
    public void commit() {
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
