package utn.tp.poi.servlet;

import utn.tp.poi.LoginRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String token = LoginRegistry.getInstance().login(username, password);

        if (token != null) {
            resp.getOutputStream().print(token);
        } else {
            throw new ServletException("Invalid username or passoword");
        }

    }

}
