package com.core.residence.model;

import java.util.Date;

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
@Document(collection = "historico_habitaciones")
public class HistoricRoom {

	@Id
    private ObjectId idHistorico;
    private ObjectId idHabitacion;
    private Date fecha;
    private double precio;
    private String estado;

    public void getHistoric(Room miroom) {
    	this.idHabitacion = miroom.getId();
    	//Quitamos del precio las letras y lo convertimos en log:
    	 String texto = miroom.getPriceInfo();
         String numeros = "";

         for (int i = 0; i < texto.length(); i++) {
             char c = texto.charAt(i);
             if (Character.isDigit(c)) {
                 numeros += c;
             }
         }
        this.precio = Long.parseLong(numeros);
        this.estado = ""+!miroom.isSoldOut();
        this.fecha = new Date();

    }
}
