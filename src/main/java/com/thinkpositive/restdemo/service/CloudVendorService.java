package com.thinkpositive.restdemo.service;

import com.thinkpositive.restdemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(Integer cloudVendorId);
    public CloudVendor getCloudVendor(Integer cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
}
