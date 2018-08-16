package pl.tomekdudek.GymManagement.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class GymTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gymticket_id")
    private int id;

    private LocalDate dateOfPurchase;
    private LocalDate expirationDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_gymticket", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "gymticket_id"))
    private List<GymTicket> gymTickets;
}
