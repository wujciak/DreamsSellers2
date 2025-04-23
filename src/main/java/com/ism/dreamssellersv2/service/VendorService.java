package com.ism.dreamssellersv2.service;

import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;

import java.util.List;

public interface VendorService {
    VendorDTO createVendor(VendorCreateDTO vendorCreateDTO);
    void deleteVendor(Integer vendorId);
    VendorDTO getVendorById(Integer vendorId);
    List<VendorDTO> getVendors();
}