package com.example.qrcodedemo.api;

import com.example.qrcodedemo.dto.QrCodeRequest;
import com.example.qrcodedemo.util.QrCodeGenerator;
import com.google.zxing.WriterException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Api(value = "QRCodeApi", description = "access to QRCode")
@RestController
@RequestMapping("/qrcode")
public class QrCodeApi {

    private String baseUri; // about other environment

    @Autowired
    public QrCodeApi(@Value("${base.uri}") String baseUri) {
        this.baseUri = baseUri;
    }

    @ApiOperation("get qrCode")
    @ApiResponses({@ApiResponse(code = 200, message = "get qrCode successfully")})
    @GetMapping(value = "/{mac}", produces = {MediaType.IMAGE_PNG_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public byte[] generateQrCode(@ApiParam(value = "111111111111") @PathVariable("mac") String mac, @Valid @ModelAttribute QrCodeRequest qrCodeRequest) throws IOException, WriterException {
        return QrCodeGenerator.getQRCodeImage(String.format("%s/xx?mac=%s", baseUri, mac),qrCodeRequest);
    }
}
