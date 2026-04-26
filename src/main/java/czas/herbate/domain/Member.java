package czas.herbate.domain;

/**
 * Domain (Entity): Represents the data object used within the application.
 * This class maps to the data structure (like a database table) and carries information 
 * between different layers (Controller, Service, Repository).
 */
public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
