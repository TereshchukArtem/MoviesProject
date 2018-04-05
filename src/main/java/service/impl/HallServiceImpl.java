package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.HallDTO;
import mapper.BeanMapper;
import model.Hall;
import service.api.Service;

import java.util.List;

public class HallServiceImpl implements Service<Integer, HallDTO> {
    private static HallServiceImpl service;
    private Dao<Integer, Hall> hallDao;
    private BeanMapper beanMapper;

    private HallServiceImpl() {
        hallDao = DaoFactory.getInstance().getHallDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized HallServiceImpl getInstance() {
        if (service == null) {
            service = new HallServiceImpl();
        }
        return service;
    }

    @Override
    public List<HallDTO> getAll() {
        List<Hall> halls = hallDao.getAll();
        List<HallDTO> hallDTOS = beanMapper.listMapToList(halls, HallDTO.class);
        return hallDTOS;
    }

    @Override
    public void save(HallDTO hallDTO) {
        Hall hall = beanMapper.singleMapper(hallDTO, Hall.class);
        hallDao.save(hall);
    }

    @Override
    public HallDTO getById(Integer id) {
        Hall hall = hallDao.getById(id);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return hallDTO;
    }

    @Override
    public void delete(Integer key) {
        hallDao.delete(key);
    }

    @Override
    public void update(HallDTO hallDTO) {
        Hall hall = beanMapper.singleMapper(hallDTO, Hall.class);
        hallDao.update(hall);
    }

    @Override
    public HallDTO getBy(String fieldName, String value) {
        Hall hall = hallDao.getBy(fieldName, value);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return hallDTO;
    }

    @Override
    public List<HallDTO> getAllBy(String fieldName, String value) {
        List<Hall> halls = hallDao.getAllBy(fieldName, value);
        List<HallDTO> hallDTOS = beanMapper.listMapToList(halls, HallDTO.class);
        return hallDTOS;
    }
}
