package com.thinkpositive.restdemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="cloud_vendor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudVendor {

    @Id
    private Integer vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorMobile;
}
