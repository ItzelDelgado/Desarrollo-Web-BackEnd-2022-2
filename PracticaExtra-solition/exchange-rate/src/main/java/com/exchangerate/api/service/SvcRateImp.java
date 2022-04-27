package com.exchangerate.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exchangerate.api.dto.DtoExchangeRatePair;
import com.exchangerate.api.dto.DtoRate;
import com.exchangerate.exception.ApiException;

@PropertySource("classpath:config/exchange-rate_data.config") // los datos de conexión a una API van en un archivo de configuración de resources
@Service
public class SvcRateImp implements SvcRate {
	
	@Value("${exchange-rate.pair.uri}") // asignamos la uri de la API a una variable
	private String pair_uri;

	@Override
	public DtoRate getRate(String currency) {
		try {
			String uri = pair_uri.replace("{currency}", currency); // reemplazamos en la uri la moneda de cambio a consultar
			
			/*
			 * RestTemplate permite hacer solicitudes HTTP
			 * utilizamos el método getForObject ya que la petición que queremos hacer tiene el verbo GET, le pasamos como parámetros la uri y la clase a mapear el body
			 * asignamos el resultado en un DTO
			 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html#getForObject-java.net.URI-java.lang.Class-
			 */
			RestTemplate rest = new RestTemplate();
			DtoExchangeRatePair ratePair = rest.getForObject(uri, DtoExchangeRatePair.class); 
			
			DtoRate out = new DtoRate(); // declaramos el DTO de respuesta del endpoint
			out.setRate(ratePair.getConversion_rate()); // le asignamos el valor de conversión del DTO obtenido de la API
			return out;
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, "No se encuentra disponible la moneda de cambio");
		}
	}
}