package controllers;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "adminservletupdate", urlPatterns={"/adminUpdate"})
public class AdminServletUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        long duration = Long.parseLong(req.getParameter("duration"));
        LocalDate startRelease = LocalDate.parse(req.getParameter("startRelease"));
        LocalDate finishRelease = LocalDate.parse(req.getParameter("finishRelease"));
        String posterUrl = req.getParameter("posterUrl");
        String trailerUrl = req.getParameter("trailerUrl");
        int id = Integer.parseInt(req.getParameter("id"));

        MovieDTO movieDTO = new MovieDTO(title, genre, description, duration, startRelease, finishRelease, posterUrl, trailerUrl);
        movieDTO.setId(id);
        MovieServiceImpl.getInstance().update(movieDTO);

        resp.sendRedirect(req.getContextPath() + "/pages/common/completed.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}