package com.core.residence;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.core.residence.user.UserControllerTest;

@SpringBootTest
class CoreResidenceMongoDbApplicationTests {

	@Test
	void contextLoads() {
		UserControllerTest userControllerTest = new UserControllerTest();
		userControllerTest.testObtenerTodosLosUsuarios();
	}

}
