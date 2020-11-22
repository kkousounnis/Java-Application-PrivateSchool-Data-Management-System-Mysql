package models;

public class Trainer extends Person {

    private String subject;

    Trainer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    Trainer(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

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
