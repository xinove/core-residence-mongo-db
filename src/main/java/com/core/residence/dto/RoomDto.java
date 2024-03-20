package com.core.residence.dto;

import com.core.residence.model.GtmData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RoomDto {
	
	private String id;
	private String origen;
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
