package com.polilabs.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.Producto;
import com.polilabs.service.iface.ILaboratorioService;
import com.polilabs.service.iface.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/laboratorio")
@CrossOrigin
public class LaboratorioController {
    @Autowired
    private ILaboratorioService ILaboratorioService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ILaboratorioService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ILaboratorioService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Laboratorio requestApi){
        return ILaboratorioService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Laboratorio requestApi){
        return ILaboratorioService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ILaboratorioService.delete(id);
    }
}
