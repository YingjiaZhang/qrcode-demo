package com.example.qrcodedemo.util;

import com.example.qrcodedemo.dto.QrCodeRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class QrCodeGenerator {

    private static ErrorCorrectionLevel level = ErrorCorrectionLevel.L;  //二维码容错率

    public static byte[] getQRCodeImage(String uri, QrCodeRequest qrCodeRequest) throws WriterException, IOException {
        MyQRCodeWriter qrCodeWriter = new MyQRCodeWriter();
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, level);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, qrCodeRequest.getCharacterSet());
        hints.put(EncodeHintType.MARGIN, qrCodeRequest.getMarginLength());   //设置白边
        int sideLength = qrCodeRequest.getSideLength();
        BitMatrix bitMatrix = qrCodeWriter.encode(uri, BarcodeFormat.QR_CODE, sideLength, sideLength, hints);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig config = new MatrixToImageConfig(qrCodeRequest.getColorValue(qrCodeRequest.getFrontColor()), qrCodeRequest.getColorValue(qrCodeRequest.getBackColor()));
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, config);
        return pngOutputStream.toByteArray();
    }

}
