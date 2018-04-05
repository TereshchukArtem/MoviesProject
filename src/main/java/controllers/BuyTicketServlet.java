package controllers;

import dto.TicketDTO;
import dto.UserDTO;
import service.impl.SessionServiceImpl;
import service.impl.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "buyticketservlet", urlPatterns={"/buyTicket"})
public class BuyTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int row = Integer.parseInt(req.getParameter("row"));
        int seat = Integer.parseInt(req.getParameter("seat"));
        int sessionId = Integer.parseInt(req.getParameter("sessionId"));
        List<TicketDTO> ticketDTO = TicketServiceImpl.getInstance().getAllBy("sessionId", String.valueOf(sessionId));
        UserDTO sessionUser = (UserDTO) req.getSession().getAttribute("user");
        TicketDTO newTicket = new TicketDTO(SessionServiceImpl.getInstance().getById(sessionId),row,seat,sessionUser.getId());
        req.getSession().setAttribute("messageByTicket", "");
        for (TicketDTO dto : ticketDTO) {
            if (dto.getRow() == newTicket.getRow() && dto.getSeat() == newTicket.getSeat()){
                req.getSession().setAttribute("messageByTicket", "Это место уже занято");
                resp.sendRedirect(req.getContextPath() + "/pages/common/regCommon/byTicket.jsp?sessionId=" + req.getParameter("sessionId"));
                return;
            }
        }
        req.getSession().setAttribute("messageByTicket", "");
        TicketServiceImpl.getInstance().save(newTicket);
        resp.sendRedirect(req.getContextPath() + "/main");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
