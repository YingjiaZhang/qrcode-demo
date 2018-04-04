package com.example.qrcodedemo.api;

import com.example.qrcodedemo.dto.QrCodeRequest;
import com.example.qrcodedemo.util.QrCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/qrcode")
public class QrCodeApi {

    private String baseUri; // about other environment

    @Autowired
    public QrCodeApi(@Value("${base.uri}") String baseUri) {
        this.baseUri = baseUri;
    }

    @GetMapping(value = "/{mac}",produces = "image/png")
    @ResponseStatus(HttpStatus.OK)
    public byte[] generateQrCode(@PathVariable("mac") String mac,@Valid @ModelAttribute QrCodeRequest qrCodeRequest) throws IOException, WriterException {
        return QrCodeGenerator.getQRCodeImage(String.format("%s/xx?mac=%s", baseUri, mac),qrCodeRequest);
    }
}
