package com.polilabs.controller;

import com.polilabs.service.iface.IPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("pdf")
@CrossOrigin
public class PdfController {

    @Autowired
    private IPdfService pdfService;

    @GetMapping("/generar")
    public ResponseEntity<?> generar() throws IOException {
        return  pdfService.generar();
    }
}
