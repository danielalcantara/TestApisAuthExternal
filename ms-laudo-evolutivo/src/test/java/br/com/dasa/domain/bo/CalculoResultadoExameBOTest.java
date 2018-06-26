package br.com.dasa.domain.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.dasa.MsLaudoEvolutivoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MsLaudoEvolutivoApplication.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class CalculoResultadoExameBOTest {

	@Autowired
	private ICalculoResultadoExame calculoResultadoExame;

	final private String RESULTADO_POSITIVO = "positivo";
	final private String RESULTADO_NEGATIVO = "negativo";

	@Test
	public void testGetStatusResultadoDeAte() {
		String value = "4,34";
		String valueReference = "de 4,00 até 5,20\\t10^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoDeA() {
		String value = "5,15";
		String valueReference = "de 4,00 a 5,20\\t10^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoDeDash() {
		String value = "4,96";
		String valueReference = "de 4,00 - 5,20\\t10^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoSuperiorA() {
		String value = "4,96";
		String valueReference = "Superior a 4,00^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoSuperiorIgualA() {
		String value = "4,00";
		String valueReference = "Superior ou igual a 4,00^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoInferiorA() {
		String value = "6,96 litros";
		String valueReference = "Inferior a 7,05^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoInferiorIgualA() {
		String value = "7,05 litros";
		String valueReference = "Inferior ou igual a 7,05^6/µ L";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoAte() {
		String value = "0,2 mg/dL";
		String valueReference = "Até 1,0 mg/dL";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_POSITIVO;
		assertEquals(result, resultExpected);
	}

	@Test
	public void testGetStatusResultadoAteNegativo() {
		String value = "2,2 mg/dL";
		String valueReference = "Até 1,0 mg/dL";
		String result = calculoResultadoExame.getStatusResultado(value, valueReference);
		String resultExpected = RESULTADO_NEGATIVO;
		assertEquals(result, resultExpected);
	}

}
