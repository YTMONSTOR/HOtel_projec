package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MexmonxonaDto {
    private Integer id;
    private Integer xonaId;
    private String fullName;

    public MexmonxonaDto() {
    }

    @Override
    public String toString() {
        return "MexmonxonaDto{" +
                "id=" + id +
                ", xonaId=" + xonaId +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public MexmonxonaDto(Integer id, Integer xonaId, String fullName) {
        this.id = id;
        this.xonaId = xonaId;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXonaId() {
        return xonaId;
    }

    public void setXonaId(Integer xonaId) {
        this.xonaId = xonaId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
