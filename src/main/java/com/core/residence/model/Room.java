package com.core.residence.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.core.residence.dto.RoomDto;

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
@Document(collection = "habitaciones")
public class Room {

	@Id
    private ObjectId id;
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
	
    public void saveRoom(RoomDto miroom) {
    	this.name = miroom.getName();
    	this.priceInfo = miroom.getPriceInfo();
    	this.externalId = miroom.getExternalId();
    	this.link = miroom.getLink();
    	this.imageLink = miroom.getImageLink();
    	this.imagePromoMessage = miroom.getImagePromoMessage();
    	this.promoMessage = miroom.getPromoMessage();
    	this.origen = miroom.getOrigen();
    }
}
