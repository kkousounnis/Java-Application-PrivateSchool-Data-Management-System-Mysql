package models;

import java.util.ArrayList;

public class TrainersPCourse {

    private Course course;
    private ArrayList<Trainer> trainersPCourse;

    TrainersPCourse() {
        trainersPCourse = new ArrayList<Trainer>();
    }

    TrainersPCourse(Course course) {
        this.course = course;
        trainersPCourse = new ArrayList<Trainer>();
    }

    public ArrayList<Trainer> getTrainersPCourseList() {
        return trainersPCourse;
    }

    public void addTrainersPCourse(Trainer trainer) {
        this.trainersPCourse.add(trainer);
    }

}
