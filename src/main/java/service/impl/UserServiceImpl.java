package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.UserDTO;
import mapper.BeanMapper;
import model.User;
import service.api.Service;

import java.util.List;

public class UserServiceImpl implements Service<Integer, UserDTO> {
    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userDao.getById(id);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = beanMapper.singleMapper(userDTO, User.class);
        userDao.save(user);
    }

    @Override
    public void delete(Integer key) {
        userDao.delete(key);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = beanMapper.singleMapper(userDTO, User.class);
        userDao.update(user);
    }

    @Override
    public UserDTO getBy(String fieldName, String value) {
        User user = userDao.getBy(fieldName, value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllBy(String fieldName, String value) {
        List<User> users = userDao.getAllBy(fieldName, value);
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }
}
