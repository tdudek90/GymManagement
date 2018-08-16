package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomekdudek.GymManagement.model.GymTicket;
import pl.tomekdudek.GymManagement.repository.GymTicketRepository;
import pl.tomekdudek.GymManagement.service.GymTicketServiceImpl;

import java.util.List;

@Controller
public class GymTicketController {

   @Autowired
   GymTicketServiceImpl gymTicketServiceImpl;


   @Autowired
    GymTicketRepository gymTicketRepository;

    @RequestMapping(value = "/tickets/{gymTicketId}", method = RequestMethod.GET)
    @ResponseBody
    public GymTicket getGymTicket(@PathVariable int gymTicketId) {
        return gymTicketRepository.findOne(gymTicketId);
    }

    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    @ResponseBody
    public List<GymTicket> getAllGymTickets(){
        return gymTicketServiceImpl.getAllGymTickets();
    }



}
