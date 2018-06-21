package br.com.hubfintech.extauthtests.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.hubfintech.extauthtests.model.TestModelReport;

public class TestReportMockFactory {
	
	static public List<TestModelReport> load() {
		List<TestModelReport> list = new ArrayList<>();
		
		for (int idx = 1; idx < 51; idx++) {
			TestModelReport modelReport = new TestModelReport();
			
			modelReport.setAccountId("fsddsfdsff****sdfdsfdsfds");
			modelReport.setAction("authorization");
			modelReport.setAmount(new BigDecimal("352.00"));
			modelReport.setCodeExpected("dfsfdfsdf");
			modelReport.setCodeReturned("sdfsdfdsfsdd");
			modelReport.setCommerceName("Estabelecimento dfsfsdfs Mock");
			modelReport.setIdx(idx);
			modelReport.setRequestJsonMessage("{ dfsd fdsfsd fdsfsdfdsfsdds }");
			modelReport.setResponseJsonMessage("{ sdfsdfsdf dsfdsfsdfdsfs }");
			modelReport.setResponseCode("200");
			modelReport.setStatus("SUCCESS");
			modelReport.setTruncCardNumber("645fdsfsfs6*****sdfdssd65468");
			modelReport.setTypeTest("fdsfsdfsdfsdf");
			modelReport.setRequestId("jfsdhfgkjdsakjdhasjk165165165561sdfsdffadfsajhbjhdbfsdbfsabd321651351351");
			list.add(modelReport);
		}
		
		return list;
	}

}
