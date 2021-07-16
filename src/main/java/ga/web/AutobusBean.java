
package ga.web;

import ga.domain.Autobus;
import ga.service.AutobusService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

@Named("autobusBean")
@RequestScoped
public class AutobusBean {
  
  Logger log = LogManager.getRootLogger();
  
  @Inject
  private AutobusService autobusService;
  
  private Autobus busSeleccionado;
  List<Autobus> buses;
  
  public AutobusBean(){
    
  }
  
  @PostConstruct
  public void inicializar(){
    buses = autobusService.listarBuses();
    busSeleccionado = new Autobus();
  }
  
  public void editListener(RowEditEvent event){
    Autobus autobus = (Autobus) event.getObject();
    autobusService.modificarBus(autobus);
  }

  public Autobus getBusSeleccionado() {
    return busSeleccionado;
  }

  public void setBusSeleccionado(Autobus busSeleccionado) {
    this.busSeleccionado = busSeleccionado;
  }

  public List<Autobus> getBuses() {
    return buses;
  }

  public void setBuses(List<Autobus> buses) {
    this.buses = buses;
  }
  
  
}
