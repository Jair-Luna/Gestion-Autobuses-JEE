
package ga.service;

import ga.domain.Autobus;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AutobusServiceWs {
  
  @WebMethod
  public List<Autobus> listarBuses();
  
}
