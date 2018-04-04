package com.example.qrcodedemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "parameterized color request")
public class QrCodeRequest {
    @ApiModelProperty(value = "RGBA: [0,0,0,255]", required = true)
    @Size(min = 4, max = 4)
    private List<Integer> frontColor;
    @ApiModelProperty(value = "RGBA: [255,255,255,255]", required = true)
    @Size(min = 4, max = 4)
    private List<Integer> backColor;
    @ApiModelProperty(value = "side length: 250", required = true)
    private int sideLength;
    @ApiModelProperty(value = "margin length: 1", required = true)
    private int marginLength;
    @ApiModelProperty(value = "characterSet: UTF-8", required = false)
    private String characterSet = "UTF-8";

    public int getColorValue(List<Integer> color){
        return new Color(color.get(0),color.get(1),color.get(2),color.get(3)).getRGB();
    }
}
