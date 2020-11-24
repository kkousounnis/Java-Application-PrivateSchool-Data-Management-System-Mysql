package models;

import interfaces.ITrainer;

public class Trainer extends Person implements ITrainer{

    private String subject;

    Trainer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    Trainer(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    

    @Override
    public String toString() {
        return "Trainer{" 
                + super.getFirstName() + super.getLastName()
                + ", subject=" + subject + '}';
    }

}
