package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.RoleDTO;
import mapper.BeanMapper;
import model.Role;
import service.api.Service;

import java.util.List;

public class RoleServiceImpl implements Service<Integer, RoleDTO> {
    private static RoleServiceImpl service;
    private Dao<Integer, Role> roleDao;
    private BeanMapper beanMapper;

    private RoleServiceImpl() {
        roleDao = DaoFactory.getInstance().getRoleDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized RoleServiceImpl getInstance() {
        if (service == null) {
            service = new RoleServiceImpl();
        }
        return service;
    }

    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = roleDao.getAll();
        List<RoleDTO> roleDTOS = beanMapper.listMapToList(roles, RoleDTO.class);
        return roleDTOS;
    }

    @Override
    public void save(RoleDTO roleDTO) {
        Role role = beanMapper.singleMapper(roleDTO, Role.class);
        roleDao.save(role);
    }

    @Override
    public RoleDTO getById(Integer id) {
        Role role = roleDao.getById(id);
        RoleDTO roleDTO = beanMapper.singleMapper(role, RoleDTO.class);
        return roleDTO;
    }

    @Override
    public void delete(Integer key) {
        roleDao.delete(key);
    }

    @Override
    public void update(RoleDTO roleDTO) {
        Role role = beanMapper.singleMapper(roleDTO, Role.class);
        roleDao.update(role);
    }

    @Override
    public RoleDTO getBy(String fieldName, String value) {
        Role role = roleDao.getBy(fieldName, value);
        RoleDTO roleDTO = beanMapper.singleMapper(role, RoleDTO.class);
        return roleDTO;
    }

    @Override
    public List<RoleDTO> getAllBy(String fieldName, String value) {
        List<Role> roles = roleDao.getAllBy(fieldName, value);
        List<RoleDTO> roleDTOS = beanMapper.listMapToList(roles, RoleDTO.class);
        return roleDTOS;
    }
}
