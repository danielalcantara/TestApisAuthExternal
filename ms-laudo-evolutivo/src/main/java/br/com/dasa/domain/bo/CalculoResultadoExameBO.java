package br.com.dasa.domain.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dasa.util.IMessageUtil;
import br.com.dasa.util.IntegerUtil;
import br.com.dasa.util.StringUtil;

@Component
public class CalculoResultadoExameBO implements ICalculoResultadoExame {

	private static Logger logger = LoggerFactory.getLogger(CalculoResultadoExameBO.class);

	@Autowired
	private IMessageUtil messages;

	final private String PATTERN_CASE_1 = "^(Superior)\\s+a\\s+\\S+";
	final private String PATTERN_CASE_2 = "^(Superior)\\s+ou\\s+igual\\s+a\\s+\\S+";
	final private String PATTERN_CASE_3 = "^(Inferior)\\s+a\\s+\\S+";
	final private String PATTERN_CASE_4 = "^(Inferior)\\s+ou\\s+igual\\s+a\\s+\\S";
	final private String PATTERN_CASE_5 = "\\S+\\s+((ate)|(até))\\s+\\S+";
	final private String PATTERN_CASE_6 = "\\S+\\s+[Aa]{1}\\s+\\S+";
	final private String PATTERN_CASE_7 = "\\S+\\s+-\\s+\\S+";
	final private String PATTERN_CASE_8 = "^at[eé]+\\s+\\S";
	final private String PATTERN_STRING_ONLY = "^\\D+$";
	final private String PATTERN_INT_OR_DOUBLE = "(\\d+\\.\\d+)|(\\d+)";

	final private String RESULTADO_POSITIVO = "positivo";
	final private String RESULTADO_NEGATIVO = "negativo";
	final private String RESULTADO_INDEFINIDO = "indefinido";
	final private String RESULTADO_SEM_VALOR = "sem_valor";
	final private String RESULTADO_SEM_VALOR_REFERENCIA = "sem_valor_referencia";

	final private String FALHA_PROCESSAMENTO_RESULTADO = "falha_processamento";
	final private String STOP_LOOP = "stop_loop";

	private Pattern registerPattern;
	private Matcher matcher;

	public String getStatusResultado(String valor, String valorReferencia) {

		int indexCapiture = 1;
		String statusResultado = "";

		if (valor == null || valor.isEmpty()) {
			statusResultado = RESULTADO_SEM_VALOR;
			return statusResultado;
		}

		if (valorReferencia == null || valorReferencia.isEmpty()) {
			statusResultado = RESULTADO_SEM_VALOR_REFERENCIA;
			return statusResultado;
		}

		if (valor.matches(PATTERN_STRING_ONLY)) {

			if (valor.trim().equals(valorReferencia.trim()))
				statusResultado = RESULTADO_POSITIVO;
			else
				statusResultado = RESULTADO_NEGATIVO;

		}

		if (statusResultado == null || statusResultado.isEmpty()) {
			statusResultado = capitureCase(valor, valorReferencia, indexCapiture++);

			while (statusResultado.isEmpty() && !STOP_LOOP.equals(statusResultado)) {
				statusResultado = capitureCase(valor, valorReferencia, indexCapiture++);
			}
		}

		if (statusResultado.isEmpty() || STOP_LOOP.equals(statusResultado))
			statusResultado = RESULTADO_INDEFINIDO;

		return statusResultado;

	}

	private String capitureCase(String valor, String valorReferencia, int caseParam) {

		String result = "";

		try {

			switch (caseParam) {
			case 1:
				registerPattern = Pattern.compile(PATTERN_CASE_1, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 2:
				registerPattern = Pattern.compile(PATTERN_CASE_2, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 3:
				registerPattern = Pattern.compile(PATTERN_CASE_3, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 4:
				registerPattern = Pattern.compile(PATTERN_CASE_4, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 5:
				registerPattern = Pattern.compile(PATTERN_CASE_5, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 6:
				registerPattern = Pattern.compile(PATTERN_CASE_6, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 7:
				registerPattern = Pattern.compile(PATTERN_CASE_7, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;
			case 8:
				registerPattern = Pattern.compile(PATTERN_CASE_8, Pattern.CASE_INSENSITIVE);
				matcher = registerPattern.matcher(valorReferencia);
				if (matcher.find())
					result = executeCase(valorReferencia, valor, caseParam);
				break;

			default:
				result = STOP_LOOP;
				break;
			}

		} catch (NumberFormatException ex) {
			logger.error(messages.getMessage("error.calculo.status.resultado", caseParam), ex);
			result = FALHA_PROCESSAMENTO_RESULTADO;
		}

		return result;

	}

	private String executeCase(String valorReferencia, String valor, int caseParam) {
		String result = "";
		String valorTest = StringUtil.normalizeValue(valor);

		if (IntegerUtil.isOnlyNumber(valorTest.replace(".", ""))) {
			Double valorDouble = Double.parseDouble(valorTest);

			valorReferencia = StringUtil.replaseCommaToDot(valorReferencia);
			registerPattern = Pattern.compile(PATTERN_INT_OR_DOUBLE);
			matcher = registerPattern.matcher(valorReferencia);

			if (!matcher.find())
				return "";

			Double valorCompare1 = Double.valueOf(matcher.group(0));

			if (caseParam == 5 || caseParam == 6 || caseParam == 7) {

				if (!matcher.find())
					return "";

				Double valorCompare2 = Double.valueOf(matcher.group(0));

				if (valorCompare1 <= valorDouble && valorDouble <= valorCompare2) {
					result = RESULTADO_POSITIVO;
				} else {
					result = RESULTADO_NEGATIVO;
				}

			} else if (caseParam == 1 || caseParam == 2) {

				if ((valorDouble > valorCompare1 && caseParam == 1)
						|| (valorDouble >= valorCompare1 && caseParam == 2)) {
					result = RESULTADO_POSITIVO;
				} else {
					result = RESULTADO_NEGATIVO;
				}

			} else if (caseParam == 3 || caseParam == 4) {

				if ((valorDouble < valorCompare1 && caseParam == 3)
						|| (valorDouble <= valorCompare1 && caseParam == 4)) {
					result = RESULTADO_POSITIVO;
				} else {
					result = RESULTADO_NEGATIVO;
				}

			} else if (caseParam == 8) {
				if (valorDouble <= valorCompare1) {
					result = RESULTADO_POSITIVO;
				} else {
					result = RESULTADO_NEGATIVO;
				}
			}
		}

		return result;
	}

}
