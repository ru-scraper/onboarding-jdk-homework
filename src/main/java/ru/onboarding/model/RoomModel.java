package ru.onboarding.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "room")
public class RoomModel implements Serializable {
    @Id
    private int id;

    //TODO Один ко многим
    private Collection<StudentModel> students = new ArrayList<>();

    public RoomModel() {
    }

    public RoomModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Collection<StudentModel> getStudents() {
        return students;
    }
}
