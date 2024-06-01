package com.cricket.CricketDatabase.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cricket")
public class CricketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jersey_id")
    int jerseyNumber;
    @Column(name = "cricketer_name")
    String cricketerName;
    @Column(name = "total_runs")
    int totalRuns;
    @Column(name = "batting_average")
    double battingAverage;
    @Column(name = "franchise_team")
    String franchiseTeam;
    public CricketEntity(){

    }

    public CricketEntity(String cricketerName, int totalRuns, double battingAverage, String franchiseTeam) {
        this.cricketerName = cricketerName;
        this.totalRuns = totalRuns;
        this.battingAverage = battingAverage;
        this.franchiseTeam = franchiseTeam;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setFranchiseTeam(String franchiseTeam) {
        this.franchiseTeam = franchiseTeam;
    }

    public String getFranchiseTeam() {
        return franchiseTeam;
    }

    @Override
    public String toString() {
        return "CricketEntity{" +
                "jerseyNumber=" + jerseyNumber +
                ", cricketerName='" + cricketerName + '\'' +
                ", totalRuns=" + totalRuns +
                ", battingAverage=" + battingAverage +
                ", franchiseTeam='" + franchiseTeam + '\'' +
                '}';
    }
}
