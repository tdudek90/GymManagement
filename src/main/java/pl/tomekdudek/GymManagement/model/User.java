package pl.tomekdudek.GymManagement.model;

import pl.tomekdudek.GymManagement.model.form.DeleteForm;
import pl.tomekdudek.GymManagement.model.form.UserForm;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tomek on 2017-11-06.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    private String name;
    private String lastname;
    private String mail;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.mail = user.getMail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public User(UserForm userForm) {
        name = userForm.getName();
        lastname = userForm.getLastname();
        mail = userForm.getMail();
        password = userForm.getPassword();
    }

    public User(DeleteForm deleteForm) {
        this.id = deleteForm.getUserId();
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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
