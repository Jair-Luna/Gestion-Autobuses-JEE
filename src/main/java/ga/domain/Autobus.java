package ga.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
  @NamedQuery(name = "Autobus.findAll", query = "SELECT a FROM Autobus a"),
  @NamedQuery(name = "Autobus.findByIdAutobus", query = "SELECT a FROM Autobus a WHERE a.idAutobus = :idAutobus"),
  @NamedQuery(name = "Autobus.findByMatricula", query = "SELECT a FROM Autobus a WHERE a.matricula = :matricula"),
  @NamedQuery(name = "Autobus.findByMarca", query = "SELECT a FROM Autobus a WHERE a.marca = :marca"),
  @NamedQuery(name = "Autobus.findByModelo", query = "SELECT a FROM Autobus a WHERE a.modelo = :modelo"),
  @NamedQuery(name = "Autobus.findByAnio", query = "SELECT a FROM Autobus a WHERE a.anio = :anio")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Autobus implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_autobus")
  private Integer idAutobus;
  
  @Size(max = 45)
  private String matricula;
  
  @Size(max = 45)
  private String marca;
  
  @Size(max = 45)
  private String modelo;
  
  @Size(max = 45)
  private String anio;
  
  @XmlTransient
  @OneToMany(mappedBy = "autobus", cascade = CascadeType.ALL)
  private List<Usuario> usuarioList;

  public Autobus() {
  }

  public Autobus(String matricula, String marca, String modelo, String anio) {
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    this.anio = anio;
  }

  public Autobus(Integer idAutobus) {
    this.idAutobus = idAutobus;
  }

  public Integer getIdAutobus() {
    return idAutobus;
  }

  public void setIdAutobus(Integer idAutobus) {
    this.idAutobus = idAutobus;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getAnio() {
    return anio;
  }

  public void setAnio(String anio) {
    this.anio = anio;
  }

  public List<Usuario> getUsuarioList() {
    return usuarioList;
  }

  public void setUsuarioList(List<Usuario> usuarioList) {
    this.usuarioList = usuarioList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idAutobus != null ? idAutobus.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Autobus)) {
      return false;
    }
    Autobus other = (Autobus) object;
    if ((this.idAutobus == null && other.idAutobus != null) || (this.idAutobus != null && !this.idAutobus.equals(other.idAutobus))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Autobus{" + "idAutobus=" + idAutobus + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + '}';
  }
  
}
