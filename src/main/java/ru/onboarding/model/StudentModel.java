package ru.onboarding.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "student")
public class StudentModel implements Serializable {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private RoomModel room;

    public StudentModel() {
    }

    public StudentModel(int id, String name, RoomModel room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RoomModel getRoom() {
        return room;
    }
}
