package br.com.dasa.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testNormalizeValue() {
		String valueTest = "6456fdsfsd.3242hgjhg,423fdsfs";
		String valueNormalized = "64563242.423";
		assertEquals(StringUtil.normalizeValue(valueTest), valueNormalized);
	}

	@Test
	public void testReplaseCommaToDot() {
		String valueTest = "6484684.648699,21654";
		String valueResult = "6484684648699.21654";
		assertEquals(StringUtil.replaseCommaToDot(valueTest), valueResult);
	}

}
