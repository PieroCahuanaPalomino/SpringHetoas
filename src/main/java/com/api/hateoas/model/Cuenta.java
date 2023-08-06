package com.api.hateoas.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
//Hereda Clase que trabaja con links (paquete de Hetoas)
public class Cuenta extends RepresentationModel<Cuenta>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20,nullable = false,unique = true)
	private String numeroDeCuenta;
	
	private float monto;

	public Cuenta(Integer id, String numeroDeCuenta) {
		super();
		this.id = id;
		this.numeroDeCuenta = numeroDeCuenta;
	}
	
	
}
