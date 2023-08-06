package com.api.hateoas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.api.hateoas.model.Cuenta;
import com.api.hateoas.repository.CuentaRepository;

@DataJpaTest
@Rollback(value = true) //IMPIDE QUE SE HAGAN REGISTROS EN EL DATABSE
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CuentaRepositoryTests {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Test
	void testAgregarCuenta() {
		Cuenta cuenta=new Cuenta(2,"10");
		Cuenta cuentaGuardada=cuentaRepository.save(cuenta);
		
		Assertions.assertThat(cuentaGuardada).isNotNull();
		Assertions.assertThat(cuentaGuardada.getId()).isGreaterThan(0);
	}
}
