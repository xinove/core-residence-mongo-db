package com.core.residence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GtmData {

    private String id;
    private String name;
    private String category;
    private int quantity;
    private String CD1;
    private String CD3;
//	    private GtmData gtmData;
	
}
