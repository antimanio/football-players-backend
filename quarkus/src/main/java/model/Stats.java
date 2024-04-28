package model;

public class Stats {
    
    public Integer pace; 
    public Integer shooting;
    public Integer passing; 
    public Integer dribbling; 
    public Integer defending;
    public Integer physical; 


    public Stats(){}

    public Stats(Integer pace, Integer shooting, Integer passing, Integer dribbling, Integer defending, Integer physical) {
        this.pace = pace;
        this.shooting = shooting;
        this.passing = passing;
        this.dribbling = dribbling;
        this.defending = defending;
        this.physical = physical;
    }

    public Integer getPace() {
        return pace;
    }

    public Integer getShooting() {
        return shooting;
    }

    public Integer getPassing() {
        return passing;
    }

    public Integer getDribbling() {
        return dribbling;
    }

    public Integer getDefending() {
        return defending;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void setPace(Integer pace) {
        this.pace = pace;
    }

    public void setShooting(Integer shooting) {
        this.shooting = shooting;
    }
    public void setPassing(Integer passing) {
        this.passing = passing;
    }
    public void setDribbling(Integer dribbling) {
        this.dribbling = dribbling;
    }
    public void setDefending(Integer defending) {
        this.defending = defending;
    }

    public void setPhysical(Integer physical) {
        this.physical = physical;
    }

    

}
