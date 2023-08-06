package com.api.hateoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hateoas.exceptions.CuentaNotFoundException;
import com.api.hateoas.model.Cuenta;
import com.api.hateoas.repository.CuentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional //Se ejecutan transacciones como ROLBACK o COMMIT
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	public List<Cuenta> listAll(){
		return cuentaRepository.findAll();
	}
	
	public Cuenta get(Integer id) {
		return cuentaRepository.findById(id).get();
	}
	
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}
	
	public void delete(Integer id) throws CuentaNotFoundException {
		if(!cuentaRepository.existsById(id)) {
			throw new CuentaNotFoundException("Cuenta no encontrada con el ID :" + id);
		}
		cuentaRepository.deleteById(id);
	}
	
	public Cuenta depositar(float monto,Integer id) {
		cuentaRepository.actualizarMonto(monto, id);
		return cuentaRepository.findById(id).get();
	}
	
	public Cuenta retirar(float monto,Integer id) {
		cuentaRepository.actualizarMonto(-monto, id);
		return cuentaRepository.findById(id).get();
	}
}
