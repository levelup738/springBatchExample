package com.my.batch.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.my.model.BoxOfficeResult;
import com.my.model.DailyBoxOffice;
import com.my.model.InputData;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BoxOfficeItemReader implements ItemReader<BoxOfficeResult>{

	@Override
	public BoxOfficeResult read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		ExchangeStrategies strategies = ExchangeStrategies.builder().codecs(clientDefaultCodecsConfigurer -> {
			clientDefaultCodecsConfigurer.defaultCodecs();
			
			
		}).build();
		
		WebClient webClient = WebClient.builder().exchangeStrategies(strategies).build();
		
		Mono<InputData> boxMono = webClient.get()
				.uri("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(InputData.class)
				.log();
		
		
		InputData result = boxMono.block();
		return result.getBoxOfficeResult();
	}

}
