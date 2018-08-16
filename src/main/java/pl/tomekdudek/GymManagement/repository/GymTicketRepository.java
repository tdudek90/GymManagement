package pl.tomekdudek.GymManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomekdudek.GymManagement.model.GymTicket;

@Repository
public interface GymTicketRepository extends JpaRepository<GymTicket, Integer> {



}
