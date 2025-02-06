package com.thinkpositive.restdemo.service.impl;

import com.thinkpositive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkpositive.restdemo.model.CloudVendor;
import com.thinkpositive.restdemo.repository.CloudVendorRepository;
import com.thinkpositive.restdemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClousVendorServiceImpl implements CloudVendorService {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    public ClousVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(Integer cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(Integer cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
