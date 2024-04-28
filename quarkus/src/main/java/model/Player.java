package model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class Player extends Stats {

    public String id;
    public String name;
    public Integer height;
    public Integer weight;
    public LocalDate birthDate;
    public String league;
    public Integer mainFoot;
    public Integer weakFoot;
    public Integer skillMoves;
    public Integer value;
    public Stats stats;


    public Player(String name, Integer height, Integer weight, LocalDate birthDate, String league, Integer mainFoot, Integer weakFoot, Integer skillMoves, Integer value, Stats stats){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.league = league;
        this.mainFoot = mainFoot;
        this.weakFoot = weakFoot;
        this.skillMoves = skillMoves;
        this.value = value;
        this.stats = stats;
    }


    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public String getLeague() {
        return league;
    }

    public Integer getMainFoot() {
        return mainFoot;
    }

    public Integer getWeakFoot() {
        return weakFoot;
    }

    public Integer getSkillMoves() {
        return skillMoves;
    }

    public Integer getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setLeague(String league) {
        this.league = league;
    }

    public void setMainFoot(Integer mainFoot) {
        this.mainFoot = mainFoot;
    }

    public void setWeakFoot(Integer weakFoot) {
        this.weakFoot = weakFoot;
    }

    public void setSkillMoves(Integer skillMoves) {
        this.skillMoves = skillMoves;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
}
