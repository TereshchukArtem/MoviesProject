package filter;

import dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/pages/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO != null && userDTO.getRole().getName().equals("Admin")){
            chain.doFilter(req,resp);
        }else {
            request.getSession().setAttribute("url", request.getRequestURI());
            request.getSession().setAttribute("message", "You have to be admin");
            response.sendRedirect(request.getContextPath() + "/pages/common/login.jsp?url=" + request.getRequestURI());
        }
    }

    @Override
    public void destroy() {
    }
}
