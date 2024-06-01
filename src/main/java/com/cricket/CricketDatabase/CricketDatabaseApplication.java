package com.cricket.CricketDatabase;

import com.cricket.CricketDatabase.Entity.CricketEntity;
import com.cricket.CricketDatabase.Repository.CricketDAO;
import com.cricket.CricketDatabase.Repository.CricketDAOImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class CricketDatabaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(CricketDatabaseApplication.class, args);
        //System.out.println("hello world");

    }

    @Bean
    public CommandLineRunner commandLineRunner(CricketDAO cricketImplementation) {
        return args -> {
            //insertAndSaveData(cricketImplementation);
            readInsertedData(cricketImplementation);
            //updateData(cricketImplementation);
            //deleteData(cricketImplementation);
        };
    }

    public void insertAndSaveData(CricketDAO cricketImplementation) {
        CricketEntity cricketerData1 =
                new CricketEntity("virat", 7000, 41.54, "RCB");
        CricketEntity cricketerData2 =
                new CricketEntity("rohit", 7000, 35.54, "MI");
        cricketImplementation.saveData(cricketerData1);
        cricketImplementation.saveData(cricketerData2);

    }

    public void readInsertedData(CricketDAO cricketImplementation) {
        int id = 1;
        List<CricketEntity> cricketerData1 = cricketImplementation.readData(id);
        System.out.println("record returned by ID");
        for (CricketEntity record : cricketerData1) {
            System.out.print(record + " ");
        }
        String name = "rohit";
        List<CricketEntity> cricketerData2 = cricketImplementation.readDataByName(name);
        System.out.println("record returned by name");
        for (CricketEntity eachRecord : cricketerData2) {
            //System.out.println(eachRecord);
        }
        List<CricketEntity> allRecords = cricketImplementation.readAllRecords();
        for (CricketEntity eachRow : allRecords) {
            System.out.println(eachRow);
        }
    }

    public void updateData(CricketDAO cricketImplementation) {
        String oldName = "virat";
        String newName = "kohli";
        List<CricketEntity> updateNeedData = cricketImplementation.updateDataByName(oldName);
        for (CricketEntity eachRecord : updateNeedData) {
            eachRecord.setCricketerName(newName);
            cricketImplementation.updateSingleData(eachRecord);
        }
    }
    public void deleteData(CricketDAO cricketImplementation){
        String name = "kohli";
        List<CricketEntity> cricketData = cricketImplementation.deleteDataByName(name);
        int count= 0;
        for(CricketEntity eachRecord : cricketData){
            count++;
            cricketImplementation.deleteDataByName(eachRecord);
        }
        System.out.println(count);
    }


}
