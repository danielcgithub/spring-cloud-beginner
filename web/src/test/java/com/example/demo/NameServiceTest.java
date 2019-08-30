package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.example.demo.NameService.NameFeignClient;

import org.junit.Test;

/**
 * @author Ryan Baxter
 */
public class NameServiceTest {

	@Test
	public void getNameTest() throws Exception {
		NameService.NameFeignClient nameFeignClient = mock(NameFeignClient.class);
		doReturn("Ryan").when(nameFeignClient).getName();
		NameService nameService = new NameService(nameFeignClient);
		String name = nameService.getName();
		assertEquals(name, "Ryan");
	}

}