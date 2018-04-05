package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.SessionDTO;
import mapper.BeanMapper;
import model.Session;
import service.api.Service;

import java.util.List;

public class SessionServiceImpl implements Service<Integer, SessionDTO> {
    private static SessionServiceImpl service;
    private Dao<Integer, Session> sessionDao;
    private BeanMapper beanMapper;

    private SessionServiceImpl() {
        sessionDao = DaoFactory.getInstance().getSessionDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized SessionServiceImpl getInstance() {
        if (service == null) {
            service = new SessionServiceImpl();
        }
        return service;
    }

    @Override
    public List<SessionDTO> getAll() {
        List<Session> sessions = sessionDao.getAll();
        List<SessionDTO> sessionDTOS = beanMapper.listMapToList(sessions, SessionDTO.class);
        return sessionDTOS;
    }

    @Override
    public void save(SessionDTO sessionDTO) {
        Session session = beanMapper.singleMapper(sessionDTO, Session.class);
        sessionDao.save(session);
    }

    @Override
    public SessionDTO getById(Integer id) {
        Session session = sessionDao.getById(id);
        SessionDTO sessionDTO = beanMapper.singleMapper(session, SessionDTO.class);
        return sessionDTO;
    }

    @Override
    public void delete(Integer key) {
        sessionDao.delete(key);
    }

    @Override
    public void update(SessionDTO sessionDTO) {
        Session session = beanMapper.singleMapper(sessionDTO, Session.class);
        session.setId(sessionDTO.getId());
        sessionDao.update(session);
    }

    @Override
    public SessionDTO getBy(String fieldName, String value) {
        Session session = sessionDao.getBy(fieldName, value);
        SessionDTO sessionDTO = beanMapper.singleMapper(session, SessionDTO.class);
        return sessionDTO;
    }

    @Override
    public List<SessionDTO> getAllBy(String fieldName, String value) {
        List<Session> sessions = sessionDao.getAllBy(fieldName, value);
        List<SessionDTO> sessionDTOS = beanMapper.listMapToList(sessions, SessionDTO.class);
        return sessionDTOS;
    }
}