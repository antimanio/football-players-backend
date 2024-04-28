package model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Player extends PanacheEntity {

    @Column
    public String name;

    @Column
    public Integer height;

    @Column
    public Integer weight;

    @Column
    public LocalDate birthDate;

    @Column
    public String league;

    @Column
    public Integer mainFoot;

    @Column
    public Integer weakFoot;

    @Column
    public Integer skillMoves;

    @Column
    public Integer value;
    
}
