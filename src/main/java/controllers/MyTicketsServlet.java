package controllers;

import dto.TicketDTO;
import dto.UserDTO;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "myticketsservlet", urlPatterns={"/myTickets"})
public class MyTicketsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO sessionUserDTO = (UserDTO) request.getSession().getAttribute("user");
        List<TicketDTO> ticketDTOList = TicketServiceImpl.getInstance().getAllBy("userId",String.valueOf(sessionUserDTO.getId()));
        request.setAttribute("ticketDTOList", ticketDTOList);
        request.getRequestDispatcher("pages/common/regCommon/myTickets.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
