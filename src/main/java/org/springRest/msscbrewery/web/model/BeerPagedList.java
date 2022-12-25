package org.springRest.msscbrewery.web.model;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<BeerDto>{

	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
		// TODO Auto-generated constructor stub
	}

	public BeerPagedList(List<BeerDto> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}
	
}