package controllers;

import dto.UserDTO;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "registerservlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String login = request.getParameter("login");
        String pasword = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));

        UserDTO userDTO = new UserDTO(login, pasword, firstName, lastName, email, sex, birthday, RoleServiceImpl.getInstance().getById(4));
        UserDTO userTestLogin = UserServiceImpl.getInstance().getBy("login", login);

        if (userTestLogin != null){
            request.getSession().setAttribute("messageByRegister", "Имя пользователя уже занято");
            response.sendRedirect(request.getContextPath() + "/pages/common/register.jsp");
        }else {
            UserServiceImpl.getInstance().save(userDTO);
            request.getSession().setAttribute("user", userDTO);
            request.getRequestDispatcher("pages/common/mainPage.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
