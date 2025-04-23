package com.ism.dreamssellersv2.controller;

import com.ism.api.VendorApi;
import com.ism.dreamssellersv2.service.VendorService;
import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController implements VendorApi {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @Override
    public ResponseEntity<VendorDTO> createVendor(VendorCreateDTO vendorCreateDTO) {
        return ResponseEntity.ok(vendorService.createVendor(vendorCreateDTO));
    }

    @Override
    public ResponseEntity<Void> deleteVendor(Integer vendorId) {
        vendorService.deleteVendor(vendorId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<VendorDTO> getVendorById(Integer vendorId) {
        return ResponseEntity.ok(vendorService.getVendorById(vendorId));
    }

    @Override
    public ResponseEntity<List<VendorDTO>> getVendors() {
        return ResponseEntity.ok(vendorService.getVendors());
    }
}