package ga.data;

import ga.domain.Autobus;
import java.util.List;

public interface AutobusDao {
  public List<Autobus> findAllAutobus();
  
  public Autobus findBusById(Autobus autobus);
  
  public void insertBus(Autobus autobus);
  
  public void updateBus(Autobus autobus);
  
  public void deleteBus(Autobus autobus);
}
