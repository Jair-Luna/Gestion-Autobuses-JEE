
package ga.service;

import ga.domain.Autobus;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface AutobusServiceRemote {
  
  public List<Autobus> listarBuses();
  
  public Autobus encontrarBusPorId(Autobus autobus);
  
  public void insertarBus(Autobus autobus);
  
  public void modificarBus(Autobus autobus);
  
  public void eliminarBus(Autobus autobus);
}
