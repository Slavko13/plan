package ru.dayPlanning.auth;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/registration")
public class RegistrationServlet extends HttpServlet {

    @Inject
    private RegistrationBean registrationBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        // UTF-8 Сохранить данные в поле
        String firstName = req.getParameter("first_name");
        String secondName = req.getParameter("second_name");
        String login = req.getParameter("login");
        String email= req.getParameter("email");
        String password = req.getParameter("password");

        registrationBean.setEmail(email);
        registrationBean.setFirst_name(firstName);
        registrationBean.setPassword(password);
        registrationBean.setSecond_name(secondName);
        registrationBean.setLogin(login);

        if (!registrationBean.createUser()) {
            req.setAttribute("message", "Придумайте другой логин!");
            req.setAttribute("first_name", firstName);
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("second_name", secondName);
            getServletContext().getRequestDispatcher("/auth/registration.xhtml").forward(
                    req, resp);
        }
        else {
            String path = req.getContextPath() + "/auth/login.xhtml";
            resp.sendRedirect(path);
        }
    }
}
