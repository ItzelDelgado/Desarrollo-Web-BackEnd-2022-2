package com.exchangerate.api.service;

import com.exchangerate.api.dto.DtoRate;

public interface SvcRate {

	public DtoRate getRate(String currency);
}
