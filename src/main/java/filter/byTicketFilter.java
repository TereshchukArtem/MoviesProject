package filter;

import dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "byTicketFilter", urlPatterns = "/pages/common/regCommon/*")
public class byTicketFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO != null){
            chain.doFilter(req,resp);
        }else {
            request.getSession().setAttribute("url", request.getRequestURI() + "?sessionId=" + request.getParameter("sessionId"));
            request.getSession().setAttribute("message", "You should sign");
            response.sendRedirect(request.getContextPath() + "/pages/common/login.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
