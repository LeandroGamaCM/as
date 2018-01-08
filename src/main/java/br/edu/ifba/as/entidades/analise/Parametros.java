package br.edu.ifba.as.entidades.analise;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parametros implements Serializable {

    private static final long serialVersionUID = -2628404174407468194L;
    
    @Id
    @GeneratedValue
    private Integer id;
     
    private Double salarioMinimo;
    private Double metricaMaxSalario;

// Relacionamentos
    


}
