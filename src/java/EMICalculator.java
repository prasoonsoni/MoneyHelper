
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/EMICalculator"})
public class EMICalculator extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String loanAmount = request.getParameter("loan_amount");
        String interestRate = request.getParameter("interest_rate");
        String loanTenure = request.getParameter("loan_tenure");
        
        Double amount = Double.parseDouble(loanAmount);
        Double rate = Double.parseDouble(interestRate);
        Double tenure = Double.parseDouble(loanTenure);
        
        Double amountToBePaid = (rate/100)*amount*tenure + amount;
        Double emiToBePaid = amountToBePaid/(tenure*12);
        PrintWriter out = response.getWriter();
        out.println("<center>");
        out.println("<h2>Amount to be paid</h2>");
        out.println(amountToBePaid);
        out.println("<h2>EMI to be paid</h2>");
        out.println(emiToBePaid);
        out.println("</center>");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
