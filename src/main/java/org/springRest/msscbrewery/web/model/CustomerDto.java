package org.springRest.msscbrewery.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
	
	private UUID Id;
	private Integer version;
	private String Name;
	
	private OffsetDateTime createdDate;
	private OffsetDateTime updateDate;
}
