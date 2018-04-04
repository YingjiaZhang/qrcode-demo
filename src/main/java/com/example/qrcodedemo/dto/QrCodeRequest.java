package com.example.qrcodedemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QrCodeRequest {
    private String uri = "111";
    @Size(min = 4, max = 4)
    private List<Integer> frontColor = Arrays.asList(0,0,0,255);
    @Size(min = 4, max = 4)
    private List<Integer> backColor = Arrays.asList(255,255,255,255);
    private int sideLength = 250;
    private int marginLength = 1;
    private String characterSet = "UTF-8";
    @JsonIgnore
    private int frontColorValue;
    @JsonIgnore
    private int backColorValue;

    private int getColorValue(List<Integer> color){
        return new Color(color.get(0),color.get(1),color.get(2),color.get(3)).getRGB();
    }

    public int getFrontColorValue() {
        return getColorValue(this.frontColor);
    }

    public int getBackColorValue() {
        return getColorValue(this.backColor);
    }
}
