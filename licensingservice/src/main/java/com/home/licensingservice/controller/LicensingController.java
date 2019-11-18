package com.home.licensingservice.controller;

import com.home.licensingservice.model.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicensingController {

    @Value("${example.property}")
    private String envDesc;

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {

        System.out.println(envDesc); // -> Getting property value from Spring cloud config server

        //return licenseService.getLicense(licenseId);
        return new License()
                .withId(licenseId)
                .withOrganizationId(organizationId)
                .withProductName("Teleco")
                .withLicenseType("Seat");
    }

    @RequestMapping (value ="/{licenseId}", method = RequestMethod.DELETE)
    public void deleteLicense (@PathVariable("organizationId") String organizationId,
                                  @PathVariable("licenseId") String licenseId) {

    }
}
