

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CurrencyConvertor"})
public class CurrencyConvertor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String currentCurrency = request.getParameter("current_currency");
        String convertTo = request.getParameter("convert_to");
        Double value = Double.parseDouble(request.getParameter("amount"));
        String result = "";
        if(currentCurrency.equals("INR") && convertTo.equals("USD")){
            result = String.valueOf(value*0.013);
        } else if (currentCurrency.equals("USD") && convertTo.equals("INR")){
            result = String.valueOf(value*76.45);
        } else if(currentCurrency.equals("INR") && convertTo.equals("EURO")){
            result = String.valueOf(value*0.012);
        } else if(currentCurrency.equals("EURO") && convertTo.equals("INR")){
            result = String.valueOf(value*82.69);
        } else if(currentCurrency.equals("USD") && convertTo.equals("EURO")){
            result = String.valueOf(value*0.92);
        } else if(currentCurrency.equals("EURO") && convertTo.equals("USD")){
            result = String.valueOf(value*1.08);
        }
        PrintWriter out = response.getWriter();
        out.println("<center>");
        out.println("<h1><u>Your Converted Currency</u></h2>");
        out.println("<h2>");
        out.println(value + " " + currentCurrency + " = " + result + " " + convertTo);
        out.println("</h2>");
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
