
package servlets;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logout = request.getParameter("action");
        if (logout != null && logout.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            

        }
        
        HttpSession session = request.getSession();
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String name = request.getParameter("incoming_name");
        String pass = request.getParameter("incoming_password");  
        String message = "Enter a Username or Password";
        User user = new User();
        
        if(name == null || pass == null || name.equals("") || pass.equals("")) {
            session.setAttribute("message", message);
            
            response.sendRedirect("login");
            return;
        } else {
            
            AccountService aservice = new AccountService();
            user = aservice.login(name, pass);
            //name = user.getUsername();
            //pass = user.getPassword();
            
            if (user != null) {
                session.setAttribute("username", name);
                response.sendRedirect("home");
            } else {
                session.setAttribute("message", "Invalid Username or Password");
                response.sendRedirect("login");
            }
            
            
        }
        
        
    }

    

    
}
