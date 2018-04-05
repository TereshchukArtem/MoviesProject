package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.MovieDTO;
import mapper.BeanMapper;
import model.Movie;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements Service<Integer, MovieDTO> {
    private static MovieServiceImpl service;
    private Dao<Integer, Movie> movieDao;
    private BeanMapper beanMapper;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (service == null) {
            service = new MovieServiceImpl();
        }
        return service;
    }

    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieDao.getAll();
        List<MovieDTO> movieDTOs = beanMapper.listMapToList(movies, MovieDTO.class);
        return movieDTOs;
    }

    @Override
    public void save(MovieDTO movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setGenre(movieDto.getGenre());
        movie.setDescription(movieDto.getDescription());
        movie.setDuration(movieDto.getDuration());
        movie.setStartRelease(movieDto.getStartRelease());
        movie.setFinishRelease(movieDto.getFinishRelease());
        movie.setPosterUrl(movieDto.getPosterUrl());
        movie.setTrailerUrl(movieDto.getTrailerUrl());
        movieDao.save(movie);
    }

    @Override
    public MovieDTO getById(Integer id) {
        Movie movie = movieDao.getById(id);
        MovieDTO movieDTO = beanMapper.singleMapper(movie, MovieDTO.class);
        return movieDTO;
    }

    @Override
    public void delete(Integer key) {
        movieDao.delete(key);
    }

    @Override
    public void update(MovieDTO movieDto) {
        Movie movie = beanMapper.singleMapper(movieDto, Movie.class);
        movieDao.update(movie);
    }

    @Override
    public MovieDTO getBy(String fieldName, String value) {
        Movie movie = movieDao.getBy(fieldName, value);
        MovieDTO movieDTO = beanMapper.singleMapper(movie, MovieDTO.class);
        return movieDTO;
    }

    @Override
    public List<MovieDTO> getAllBy(String fieldName, String value) {
        List<Movie> movies = movieDao.getAllBy(fieldName, value);
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDTO movieDTO = new MovieDTO();

            movieDTO.setId(movie.getId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setGenre(movie.getGenre());
            movieDTO.setDescription(movie.getDescription());
            movieDTO.setDuration(movie.getDuration());
            movieDTO.setStartRelease(movie.getStartRelease());
            movieDTO.setFinishRelease(movie.getFinishRelease());
            movieDTO.setPosterUrl(movie.getPosterUrl());
            movieDTO.setTrailerUrl(movie.getTrailerUrl());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }
}
