package br.com.dasa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.domain.dto.ExameDTO;
import br.com.dasa.domain.service.ILaudoEvolutivoService;
import br.com.dasa.util.IMessageUtil;

@RestController
@RequestMapping("/laudoevolutivo")
public class LaudoEvolutivoController {

	private static Logger logger = LoggerFactory.getLogger(LaudoEvolutivoController.class);

	@Autowired
	private ILaudoEvolutivoService laudoService;

	@Autowired
	private IMessageUtil messages;

	@RequestMapping(value = "/fap/{fap}/{qtdLaudos}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorFap(@PathVariable Long fap, @PathVariable Integer qtdLaudos) {

		if (fap == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		logger.info(messages.getMessage("msg.init.request.fap", fap.toString()));

		List<ExameDTO> exameDTOs = new ArrayList<>();

		try {

			exameDTOs = laudoService.getExamesResultByFap(fap, qtdLaudos);

		} catch (Exception ex) {

			logger.error(messages.getMessage("error.requisicao.fap", fap.toString()) + ex.getMessage());
			return new ResponseEntity<String>(messages.getMessage("error.exception") + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		logger.info(messages.getMessage("msg.end.request.fap", fap.toString()));

		if (exameDTOs.isEmpty()) {
			return new ResponseEntity<String>(messages.getMessage("error.not.result.fap"), HttpStatus.OK);
		}

		return new ResponseEntity<List<ExameDTO>>(exameDTOs, HttpStatus.OK);

	}

	@RequestMapping(value = "/cip/{cip}/{marcaOrigem}/{qtdLaudos}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorCip(@PathVariable Long cip, @PathVariable String marcaOrigem,
			@PathVariable Integer qtdLaudos) {

		if (cip == null || marcaOrigem == null || marcaOrigem.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		logger.info(messages.getMessage("msg.init.request.cip", cip.toString()));

		List<ExameDTO> exameDTOs = new ArrayList<>();

		try {

			exameDTOs = laudoService.getExamesResultByCip(cip, marcaOrigem, qtdLaudos);

		} catch (Exception ex) {

			logger.error(messages.getMessage("error.requisicao.cip", cip.toString()) + ex.getMessage());
			return new ResponseEntity<String>(messages.getMessage("error.exception") + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		logger.info(messages.getMessage("msg.end.request.cip", cip.toString()));

		if (exameDTOs.isEmpty()) {
			return new ResponseEntity<String>(messages.getMessage("error.not.result.cip"), HttpStatus.OK);
		}

		return new ResponseEntity<List<ExameDTO>>(exameDTOs, HttpStatus.OK);

	}

}
