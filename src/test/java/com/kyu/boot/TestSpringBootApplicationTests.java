package com.kyu.boot;

import com.kyu.boot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringBootApplicationTests {

	@Autowired
	private HelloService helloService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void 트랜잭션테스트WithNPE() {
		assertThat(helloService.getUsers().size(), is(4));

		try {
			// save user
			helloService.getUserByOccurNPE();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}


		helloService.getUsers().forEach(System.out::println);
		assertThat(helloService.getUsers().size(), is(4));
	}

	@Test
	public void 트랜잭션테스트WithNormal() {
		assertThat(helloService.getUsers().size(), is(4));
		// save user
		helloService.getUser();
		assertThat(helloService.getUsers().size(), is(5));
	}

}
