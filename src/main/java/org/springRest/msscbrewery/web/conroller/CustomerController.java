package org.springRest.msscbrewery.web.conroller;

import java.net.URI;
import java.util.UUID;

import org.springRest.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@GetMapping("/{Id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID Id) {
		CustomerDto cust = CustomerDto.builder()
				.Id(Id)
				.Name("Cliffod Spector")
				.version(23)
				.build();
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody @Validated CustomerDto cust){
		cust.setId(UUID.randomUUID());
		String url="/api/v1/customer/"+cust.getId().toString();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(url));
		return new ResponseEntity<>(cust,headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID Id, @RequestBody @Validated CustomerDto cust) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable UUID Id) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
