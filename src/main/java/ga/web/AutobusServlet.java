
package ga.web;

import ga.domain.Autobus;
import ga.service.AutobusService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/autobuses")
public class AutobusServlet extends HttpServlet{
  
  @Inject
  AutobusService autobusService;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    List<Autobus> autobuses = autobusService.listarBuses();
    System.out.println("autobuses: " + autobuses);
    request.setAttribute("autobuses", autobuses);
    request.getRequestDispatcher("/listadoBuses.jsp").forward(request, response);
  }
}

