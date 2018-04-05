package controllers;

import dto.UserDTO;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pasword = request.getParameter("password");
        String url = request.getSession().getAttribute("url").toString();

        UserDTO userDTO = UserServiceImpl.getInstance().getBy("login",login);

        if (userDTO != null && userDTO.getPassword().equals(pasword)){
            if (url == null){
                url = request.getContextPath() + "/main";
            }
            request.getSession().setAttribute("user", userDTO);
            response.sendRedirect(url);
        }else {
            request.getSession().setAttribute("message", "Wrong users name or password");
            response.sendRedirect(request.getContextPath() + "/pages/common/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
