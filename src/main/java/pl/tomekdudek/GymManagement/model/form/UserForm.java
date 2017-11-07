package pl.tomekdudek.GymManagement.model.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserForm {

    private int id;
    @NotEmpty(message = "Name may not be empty")
    private String name;
    @NotEmpty(message = "Lastname may not be empty")
    private String lastname;
    @NotEmpty(message = "Mail may not be empty")
    @Email
    private String mail;
    @NotEmpty(message = "Password may not be empty")
    private String password;

    public UserForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
