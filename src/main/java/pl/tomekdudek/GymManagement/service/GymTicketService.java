package pl.tomekdudek.GymManagement.service;

import pl.tomekdudek.GymManagement.model.GymTicket;

import java.util.List;

public interface GymTicketService {

    void addGymTicket(GymTicket gymTicket);

    GymTicket getGymTicket(int gymTicketId);

    List<GymTicket> getAllGymTickets();
}
