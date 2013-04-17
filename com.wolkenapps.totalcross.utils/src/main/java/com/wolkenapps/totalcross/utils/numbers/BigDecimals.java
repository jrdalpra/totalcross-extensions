package com.wolkenapps.totalcross.utils.numbers;

import totalcross.sys.InvalidNumberException;
import totalcross.util.BigDecimal;

public class BigDecimals {

	private BigDecimals() {
	}

	public static BigDecimal create(double value) {
		try {
			return new BigDecimal(value);
		} catch (InvalidNumberException erro) {
			throw new RuntimeException(erro);
		}
	}

}
