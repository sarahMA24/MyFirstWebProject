package MSP;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectAndNameDAOServlet
 */
@WebServlet("/list")
public class SubjectAndNameDAOServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	SubjectAndNameDAO dao = new SubjectAndNameDAO();
 
        try {
 
            List<SubjectAndName> listSC = dao.list();
            request.setAttribute("listSC", listSC);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("SubjectAndName.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
