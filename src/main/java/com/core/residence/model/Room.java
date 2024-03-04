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
public class Room {

	private String name;
	private String priceInfo;
	private String externalId;
    private String link;
    private String imageLink;
    private String imagePromoMessage;
    private String promoMessage;
    private boolean favorite;
    private boolean soldOut;
    private boolean comingSoon;
    private int contentId;
    private GtmData gtmData;
	
}
