package com.polilabs.service.impl;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.polilabs.service.iface.IPdfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class PdfServiceImpl implements IPdfService {
    @Override
    public ResponseEntity<?> generar() throws IOException {
        ConverterProperties props = new ConverterProperties().setBaseUri("./src/main/resources/");
        HtmlConverter.convertToPdf(new FileInputStream("./src/main/resources/testPdf.html"), new FileOutputStream("./src/main/resources/nada.pdf"), props);

        String filePath = "./src/main/resources/nada.pdf";
        byte[] input_file = Files.readAllBytes(Paths.get(filePath));
        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
        String encodedString =  new String(encodedBytes);


        File fichero = new File(filePath);
        fichero.delete();
        Map<String, Object> response = new HashMap<>();
        response.put("status","success");
        response.put("base64",encodedString.toString());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
