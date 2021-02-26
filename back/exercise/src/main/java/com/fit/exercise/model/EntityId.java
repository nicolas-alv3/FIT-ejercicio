package com.fit.exercise.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class EntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public EntityId(){
    }

    public EntityId(long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public int idAsInt(){
        return (int) id;
    }

    public void setId(long id){
        this.id = id;
    }
}
