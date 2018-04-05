package controllers;

import dto.MovieDTO;
import dto.SessionDTO;
import service.impl.MovieServiceImpl;
import service.impl.SessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieServlet", urlPatterns={"/movie"})
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        List<SessionDTO> sessionDTOList = SessionServiceImpl.getInstance().getAllBy("movieId", request.getParameter("id"));

        request.setAttribute("movieDTO", movieDTO);
        request.setAttribute("sessionDTOList", sessionDTOList);
        request.getRequestDispatcher("pages/common/movie.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}