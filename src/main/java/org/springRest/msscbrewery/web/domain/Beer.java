package org.springRest.msscbrewery.web.domain;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
	
	@Id
	@GeneratedValue(generator ="UUID")
	@GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
	@Column(length=36, columnDefinition ="varchar", updatable=false,nullable=false)
	private UUID Id;
	
	@Version
	private Long Version;
	
	@CreationTimestamp
	@Column(updatable=false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp updatedDate;
	
	private String beerName;
	private String beerStyle;
	
	@Column(unique=true)
	private Long upc;
	private Integer minOnHand;
	private Integer quantityToBrew;
	
}
