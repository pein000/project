package com.one.shop.repository.basic;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.EntityPath;
import com.one.shop.util.ShopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by pein on 2015/10/29.
 */
@Repository
@Transactional
public abstract class QuerydslRepository<T> extends QueryDslRepositorySupport {

    @Autowired
    private EntityManager em;

    private EntityInformation entityInformation;

    private Class<T> domainClass;
    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    protected QuerydslRepository(Class<T> domainClass) {
        super(domainClass);
        this.domainClass = domainClass;
    }

    protected JPQLQuery from(EntityPath<?>... paths) {
        return super.from(paths);
    }

    @Transactional
    public <S extends T> void save(S entity) {
        em.persist(entity);
    }

    @Transactional
    public <S extends T> void save(List<S> entityList) {
        //entityList.forEach(em::persist); //jdk8
        for(S entity:entityList) {
            if(entityInformation.isNew(entity)) {
                em.persist(entity);
            }else {
                em.merge(entity);
            }

        }
    }

    @Autowired
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        entityInformation = JpaEntityInformationSupport.getMetadata(domainClass, em);
    }

    public EntityManager getEntityManager(){
        return this.em;
    }

    private void go(){

    }
}
