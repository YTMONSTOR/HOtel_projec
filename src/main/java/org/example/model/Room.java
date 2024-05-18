package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.RoomType;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Room {
    private Integer id;
    private String name;
    private Integer hotelId;
    private double price;
    private RoomType roomType;
    private boolean bor;

}
