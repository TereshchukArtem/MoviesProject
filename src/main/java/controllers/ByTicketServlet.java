package controllers;

import dto.TicketDTO;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "byticketservlet", urlPatterns={"/byTicket"})
public class ByTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketDTO ticketDTO = TicketServiceImpl.getInstance().getBy("sessionId", req.getParameter("id"));
        req.setAttribute("ticketDTO", ticketDTO);
        req.getRequestDispatcher("pages/common/regCommon/byTicket.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
