package com.ism.dreamssellersv2.controller;

import com.ism.api.VendorApi;
import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController implements VendorApi {
    @Override
    public ResponseEntity<VendorDTO> createVendor(VendorCreateDTO vendorCreateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteVendor(Integer vendorId) {
        return null;
    }

    @Override
    public ResponseEntity<VendorDTO> getVendorById(Integer vendorId) {
        return null;
    }

    @Override
    public ResponseEntity<List<VendorDTO>> getVendors() {
        return null;
    }
}
