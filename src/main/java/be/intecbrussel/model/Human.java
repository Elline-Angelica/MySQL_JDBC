package be.intecbrussel.model;

public class Human {
    private String name;
    private String lastname;
    private int hateLevelTowardsAnthony = 20;
    private String gender;

    public Human(String name, String lastname, String gender){
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
