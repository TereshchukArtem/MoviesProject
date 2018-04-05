package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.TicketDTO;
import mapper.BeanMapper;
import model.*;
import service.api.Service;

import java.util.List;

public class TicketServiceImpl implements Service<Integer, TicketDTO> {
    private static TicketServiceImpl service;
    private Dao<Integer, Ticket> ticketDao;
    private BeanMapper beanMapper;

    private TicketServiceImpl() {
        ticketDao = DaoFactory.getInstance().getTicketDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized TicketServiceImpl getInstance() {
        if (service == null) {
            service = new TicketServiceImpl();
        }
        return service;
    }

    @Override
    public List<TicketDTO> getAll() {
        List<Ticket> tickets = ticketDao.getAll();
        List<TicketDTO> ticketDTOS = beanMapper.listMapToList(tickets, TicketDTO.class);
        return ticketDTOS;
    }

    @Override
    public void save(TicketDTO ticketDTO) {
        Ticket ticket = beanMapper.singleMapper(ticketDTO, Ticket.class);
        ticketDao.save(ticket);
    }

    @Override
    public TicketDTO getById(Integer id) {
        Ticket ticket = ticketDao.getById(id);
        TicketDTO ticketDTO = beanMapper.singleMapper(ticket, TicketDTO.class);
        return ticketDTO;
    }

    @Override
    public void delete(Integer key) {
        ticketDao.delete(key);
    }

    @Override
    public void update(TicketDTO ticketDTO) {
        Ticket ticket = beanMapper.singleMapper(ticketDTO, Ticket.class);
        ticketDao.update(ticket);
    }

    @Override
    public TicketDTO getBy(String fieldName, String value) {
        Ticket ticket = ticketDao.getBy(fieldName, value);
        TicketDTO ticketDTO = beanMapper.singleMapper(ticket, TicketDTO.class);
        return ticketDTO;
    }

    @Override
    public List<TicketDTO> getAllBy(String fieldName, String value) {
        List<Ticket> tickets = ticketDao.getAllBy(fieldName, value);
        List<TicketDTO> ticketDTOS = beanMapper.listMapToList(tickets, TicketDTO.class);
        return ticketDTOS;
    }
}
