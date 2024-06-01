package com.cricket.CricketDatabase.controller;

import com.cricket.CricketDatabase.Entity.CricketEntity;
import com.cricket.CricketDatabase.Repository.CricketDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CricketController {

    private CricketDAO cricketDAO;
     public CricketController(CricketDAO cricketDAO){
         this.cricketDAO = cricketDAO;     }
@GetMapping("/crickets")
    public List<CricketEntity> getAllRecords(){
return cricketDAO.readAllRecords();
    }
}
