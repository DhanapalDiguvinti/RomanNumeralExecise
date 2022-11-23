package test.com.roman.digits.numerals.romanconversion.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.roman.digits.numerals.romanconversion.controller.ConversionController;
import com.roman.digits.numerals.romanconversion.service.ConversionService;

@SpringBootTest(classes = ConversionController.class)
public class ConversionControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ConversionController conversionController;

	@MockBean
	private ConversionService conversionService;
	
	@Test
	public void convertNumeberToRomanTest1() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/convertNumeberToRoman/1903").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$", is("MCMIII")));

	}

}