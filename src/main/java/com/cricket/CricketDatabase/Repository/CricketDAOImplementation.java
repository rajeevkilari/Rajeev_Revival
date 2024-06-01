package com.cricket.CricketDatabase.Repository;

import com.cricket.CricketDatabase.Entity.CricketEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CricketDAOImplementation implements CricketDAO {
    @Autowired
    private EntityManager entityManager;

    public CricketDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveData(CricketEntity cricketerData) {
        entityManager.persist(cricketerData);
        System.out.println("record created");
    }

    @Override
    @Transactional
    public List<CricketEntity> readData(Integer id) {
        TypedQuery<CricketEntity> query =
                entityManager.createQuery(" SELECT c FROM CricketEntity c WHERE c.jerseyNumber= :conditionalData", CricketEntity.class);
        query.setParameter("conditionalData", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<CricketEntity> readDataByName(String name) {
        TypedQuery<CricketEntity> query =
                entityManager.createQuery("SELECT c FROM CricketEntity c WHERE c.cricketerName= :conditionalData ", CricketEntity.class);
        query.setParameter("conditionalData", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<CricketEntity> readAllRecords() {
        TypedQuery<CricketEntity> query = entityManager.createQuery("SELECT c FROM CricketEntity c", CricketEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<CricketEntity> updateDataByName(String name) {
        System.out.println(name);
        TypedQuery<CricketEntity> query =
                entityManager.createQuery("SELECT c FROM CricketEntity c WHERE cricketerName = :conditionalData", CricketEntity.class);
        query.setParameter("conditionalData", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateSingleData(CricketEntity cricketerData){
        entityManager.merge(cricketerData);
    }

    @Override
    @Transactional
    public void deleteDataByName(CricketEntity cricketData){
        entityManager.remove(entityManager.merge(cricketData));
    }

    @Override
    @Transactional
    public List<CricketEntity> deleteDataByName(String name){
       TypedQuery<CricketEntity> query =
               entityManager.createQuery("SELECT c FROM CricketEntity c WHERE c.cricketerName= :conditionalData", CricketEntity.class);
       query.setParameter("conditionalData", name);
       return query.getResultList();

    }
}
