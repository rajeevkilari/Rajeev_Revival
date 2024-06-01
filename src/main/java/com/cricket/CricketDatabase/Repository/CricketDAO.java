package com.cricket.CricketDatabase.Repository;

import com.cricket.CricketDatabase.Entity.CricketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CricketDAO  {
     void saveData(CricketEntity cricketerData);
     List<CricketEntity> readData(Integer id);
     List<CricketEntity> readDataByName(String name);

     List<CricketEntity> readAllRecords();

     List<CricketEntity> updateDataByName(String name);

     void updateSingleData(CricketEntity cricketerData);

     List<CricketEntity> deleteDataByName(String name);

     void deleteDataByName(CricketEntity cricketData);

}
