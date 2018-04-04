package com.example.qrcodedemo.api;

import com.example.qrcodedemo.dto.QrCodeRequest;
import com.example.qrcodedemo.util.QrCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeApi {

    @GetMapping(produces = "image/png")
    @ResponseStatus(HttpStatus.OK)
    public byte[] generateQrCode(@Valid @ModelAttribute QrCodeRequest qrCodeRequest) throws IOException, WriterException {
        return QrCodeGenerator.getQRCodeImage(qrCodeRequest);
    }
}
