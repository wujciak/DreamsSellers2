package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.VendorMapper;
import com.ism.dreamssellersv2.model.VendorEntity;
import com.ism.dreamssellersv2.repository.VendorRepository;
import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorEntityToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Integer vendorId) {
        VendorEntity vendorEntity = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        return vendorMapper.vendorEntityToVendorDTO(vendorEntity);
    }

    @Override
    public VendorDTO createVendor(VendorCreateDTO vendorCreateDTO) {
        VendorEntity vendorEntity = vendorMapper.vendorCreateDTOToVendorEntity(vendorCreateDTO);
        return vendorMapper.vendorEntityToVendorDTO(vendorRepository.save(vendorEntity));
    }

    @Override
    public void deleteVendor(Integer vendorId) {
        if (!vendorRepository.existsById(vendorId)) {
            throw new RuntimeException("Vendor not found");
        }
        vendorRepository.deleteById(vendorId);
    }
}