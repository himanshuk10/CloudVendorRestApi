package com.thinkpositive.restdemo.controller;

import com.thinkpositive.restdemo.model.CloudVendor;
import com.thinkpositive.restdemo.response.ResponceHandler;
import com.thinkpositive.restdemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read specific cloud vendor details from DB
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") Integer vendorId){
        return ResponceHandler.responseBuilder("Requested cloud vendor deatils are here",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    //Read all cloud vendor details from DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    //Create new cloud Vendor
    @PostMapping
    public String postCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    //for making some changes means updating something
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated Successfully";
    }

    //for deleting vendor by their id
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") Integer vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully";
    }
}
