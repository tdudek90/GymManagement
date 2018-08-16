package pl.tomekdudek.GymManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomekdudek.GymManagement.model.GymTicket;
import pl.tomekdudek.GymManagement.repository.GymTicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GymTicketServiceImpl implements GymTicketService {

    @Autowired
    GymTicketRepository gymTicketRepository;

    @Override
    public void addGymTicket(GymTicket gymTicket) {
        gymTicketRepository.save(gymTicket);
    }

    @Override
    public GymTicket getGymTicket(int gymTicketId) {
        return gymTicketRepository.getOne(gymTicketId);
    }

    public List<GymTicket> getAllGymTickets() {
        List<GymTicket> gymTickets = new ArrayList<>(gymTicketRepository.findAll());
        return gymTickets;

    }
}
