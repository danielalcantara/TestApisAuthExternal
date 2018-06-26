package br.com.dasa.domain.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.MsLaudoEvolutivoApplication;
import br.com.dasa.domain.dto.ExameDTO;
import br.com.dasa.domain.repository.ILaudoEvolutivoRepository;
import br.com.dasa.infra.response.laudo.entity.Amostra;
import br.com.dasa.infra.response.laudo.entity.AmostraFull;
import br.com.dasa.infra.response.laudo.entity.Exame;
import br.com.dasa.infra.response.laudo.entity.Laudo;
import br.com.dasa.infra.response.laudo.entity.Paciente;
import br.com.dasa.infra.response.laudo.entity.Requisicao;
import br.com.dasa.infra.response.laudo.entity.Resultado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MsLaudoEvolutivoApplication.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class LaudoEvolutivoServiceTest {

	@Autowired
	ILaudoEvolutivoService laudoEvolutivoService;

	@Mock
	ILaudoEvolutivoRepository laudoEvolutivoRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExamesResultByFap() throws JsonParseException, JsonMappingException, IOException, JSONException {

		int qtdLaudos = 3;
		Long fap = 64564654L;
		List<Laudo> laudosByFap = generateListLaudoByFap();
		List<Laudo> laudosByCid = generateListLaudoByCid(qtdLaudos);
		ILaudoEvolutivoService laudoEvolutivoServiceSpy = spy(laudoEvolutivoService);

		when(laudoEvolutivoRepo.getLaudosByFap(fap)).thenReturn(laudosByFap);
		when(laudoEvolutivoRepo.getLaudosByCip(Long.valueOf(laudosByFap.get(0).getPaciente().getCodigoOrigem()),
				laudosByFap.get(0).getMarcaOrigem(), qtdLaudos)).thenReturn(laudosByCid);
		doReturn(laudoEvolutivoRepo).when(laudoEvolutivoServiceSpy).getLaudoRepository();

		List<ExameDTO> exameDTOs = laudoEvolutivoServiceSpy.getExamesResultByFap(fap, qtdLaudos);

		assertEquals(exameDTOs.size(), qtdLaudos * 9);

	}

	@Test
	public void testGetExamesResultByCip() throws JsonParseException, JsonMappingException, IOException, JSONException {

		int qtdLaudos = 3;
		Long cip = 64564654L;
		String marcaOrigem = "Marca Teste";
		List<Laudo> laudosByCid = generateListLaudoByCid(qtdLaudos);
		ILaudoEvolutivoService laudoEvolutivoServiceSpy = spy(laudoEvolutivoService);

		when(laudoEvolutivoRepo.getLaudosByCip(Long.valueOf(cip), marcaOrigem, qtdLaudos)).thenReturn(laudosByCid);
		doReturn(laudoEvolutivoRepo).when(laudoEvolutivoServiceSpy).getLaudoRepository();

		List<ExameDTO> exameDTOs = laudoEvolutivoServiceSpy.getExamesResultByCip(cip, marcaOrigem, qtdLaudos);

		assertEquals(exameDTOs.size(), qtdLaudos * 9);

	}

	private List<Laudo> generateListLaudoByFap() {

		List<Laudo> laudos = new ArrayList<>();
		Laudo laudo = new Laudo();

		laudo.setPaciente(new Paciente());
		laudo.setMarcaOrigem("Marca Teste");
		laudo.getPaciente().setCodigoOrigem("64864684");
		laudos.add(laudo);

		return laudos;

	}

	private List<Laudo> generateListLaudoByCid(int qtdLaudos) {

		List<Laudo> laudos = new ArrayList<>();

		for (int indexLaudo = 0; indexLaudo < qtdLaudos; indexLaudo++) {
			Laudo laudo = new Laudo();
			List<Requisicao> requisicoes = new ArrayList<>();
			laudo.setRequisicoes(requisicoes);
			laudos.add(laudo);

			for (int indexReq = 0; indexReq < qtdLaudos; indexReq++) {
				Requisicao requisicao = new Requisicao();
				List<Exame> exames = new ArrayList<>();
				List<AmostraFull> amostraFulls = new ArrayList<>();
				requisicao.setDataRequisicao("data " + indexReq);
				requisicoes.add(requisicao);
				requisicao.setAmostras(amostraFulls);
				requisicao.setExames(exames);

				for (int indexAmostra = 0; indexAmostra < qtdLaudos; indexAmostra++) {
					AmostraFull amostraFull = new AmostraFull();
					amostraFull.setSequencia("sequencial" + indexReq);
					amostraFull.setDataColeta("data" + indexReq);
					amostraFulls.add(amostraFull);
				}

				for (int indexExame = 0; indexExame < qtdLaudos; indexExame++) {
					Exame exame = new Exame();
					List<Resultado> resultados = new ArrayList<>();
					exame.setResultados(resultados);
					exame.setNome("exame" + indexExame);
					exames.add(exame);

					for (int indexResult = 0; indexResult < qtdLaudos; indexResult++) {
						Resultado resultado = new Resultado();
						List<Resultado> subResultados = new ArrayList<>();

						resultado.setSubResultados(subResultados);
						resultado.setDescricao("descricao" + indexResult);
						resultado.setCodigo("codigo" + indexResult);
						resultado.setValor("valor" + indexResult);

						Amostra amostra = new Amostra();
						amostra.setSequencia("sequencial" + indexReq);
						resultado.setAmostra(amostra);

						for (int indexSubResult = 0; indexSubResult < qtdLaudos; indexSubResult++) {
							Resultado subResultado = new Resultado();
							resultado.getSubResultados().add(subResultado);

							subResultado.setDescricao("descricao" + indexSubResult);
							subResultado.setCodigo("codigo" + indexSubResult);
							subResultado.setValor("valor" + indexSubResult);
							subResultado.setAmostra(amostra);
						}

						resultados.add(resultado);
					}

				}
			}
		}

		return laudos;

	}

}
