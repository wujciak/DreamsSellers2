package com.ism.dreamssellersv2.service;

import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getVendors();
    VendorDTO getVendorById(Integer vendorId);
    VendorDTO createVendor(VendorCreateDTO vendorCreateDTO);
    void deleteVendor(Integer vendorId);
}