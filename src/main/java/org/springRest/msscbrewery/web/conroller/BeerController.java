package org.springRest.msscbrewery.web.conroller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springRest.msscbrewery.web.model.BeerDto;
import org.springRest.msscbrewery.web.model.BeerStyleEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
		
		BeerDto beer=BeerDto.builder()
				.Id(beerId)
				.beerName("Stock pile")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
		log.debug(beer.getBeerName());
		return new ResponseEntity<>(beer,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
		 String url="/api/v1/beer/"+beerDto.getId().toString();
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(URI.create(url));
		 ResponseEntity Resp=new ResponseEntity<>(beerDto,headers,HttpStatus.CREATED);
		//Todo impl
		return Resp;
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> UpateBeer(@PathVariable("beerId") UUID beerId,@RequestBody @Validated BeerDto beerDto){
		//Todo impl
		return new ResponseEntity<>(beerDto,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId) {
		//Todo impl
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
