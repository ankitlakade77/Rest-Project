package org.springRest.msscbrewery.web.repositories;

import java.util.UUID;

import org.springRest.msscbrewery.web.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepositories extends PagingAndSortingRepository<Beer, UUID>{

}
