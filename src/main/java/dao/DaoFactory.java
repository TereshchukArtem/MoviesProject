package dao;

import dao.api.Dao;
import dao.imp.*;
import helper.PropertyHolder;
import model.*;

public class DaoFactory {
    private static DaoFactory instance = null;
    private Dao<Integer, Movie> movieDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Role> roleDao;
    private Dao<Integer, Hall> hallDao;
    private Dao<Integer, Ticket> ticketDao;
    private Dao<Integer, Session> sessionDao;
    private DaoFactory(){
        loadDaos();
    }

    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
        if(PropertyHolder.getInstance().isInMemoryDB()){
            //inmemory daos
        }else{
            //jdbc daos
            movieDao = MovieDaoImpl.getInstance();
            userDao = new UserDaoImpl();
            roleDao = new RoleDaoImpl();
            hallDao = new HallDaoImpl();
            ticketDao = new TicketDaoImpl();
            sessionDao = new SessionDaoImpl();
        }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    public static void setInstance(DaoFactory instance) {
        DaoFactory.instance = instance;
    }

    public Dao<Integer, User> getUserDao() {
        return userDao;
    }

    public void setUserDao(Dao<Integer, User> userDao) {
        this.userDao = userDao;
    }

    public Dao<Integer, Role> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(Dao<Integer, Role> roleDao) {
        this.roleDao = roleDao;
    }

    public Dao<Integer, Hall> getHallDao() {
        return hallDao;
    }

    public void setHallDao(Dao<Integer, Hall> hallDao) {
        this.hallDao = hallDao;
    }

    public Dao<Integer, Ticket> getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(Dao<Integer, Ticket> ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Dao<Integer, Session> getSessionDao() {
        return sessionDao;
    }

    public void setSessionDao(Dao<Integer, Session> sessionDao) {
        this.sessionDao = sessionDao;
    }
}
