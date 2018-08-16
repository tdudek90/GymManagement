package pl.tomekdudek.GymManagement.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class GymTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gymticket_id")
    private int id;
    @Column(name = "user_id")
    private int user_id;
    private Date dateOfPurchase;
    private Date expirationDate;

    public GymTicket() {
    }

    public GymTicket(int id, int user_id, Date dateOfPurchase, Date expirationDate) {
        this.id = id;
        this.user_id = user_id;
        this.dateOfPurchase = dateOfPurchase;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "GymTicket{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", dateOfPurchase=" + dateOfPurchase +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
