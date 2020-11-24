package com.polilabs.service.iface;

import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IPdfService {
    ResponseEntity<?> generar() throws IOException;
}
