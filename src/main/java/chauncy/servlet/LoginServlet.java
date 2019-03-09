package chauncy.servlet;

import chauncy.service.ManagerLoginService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        logger.debug("account:"+account+"|password:"+password);
        ManagerLoginService service = new ManagerLoginService(account,password);
        if (service.loginSuccess()){//登录成功
            logger.debug("login success");
            req.getSession().setAttribute("loginState","1");
        }else{//登录失败
            logger.debug("login fail");
        }
        resp.sendRedirect("index.jsp");
    }
}
