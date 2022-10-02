package com.mcb.test.Test.controller.region;

import com.mcb.test.Test.model.dto.region.RegionListElementDTO;
import com.mcb.test.Test.service.region.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionAPIController {

    @Autowired
    private RegionService regionService;

    /**
     * Retrieve all regions list
     * @return
     */
    @GetMapping()
    private ResponseEntity<List<RegionListElementDTO>> getAllRegions() {
        return new ResponseEntity<List<RegionListElementDTO>>(this.regionService.getAllRegions(), HttpStatus.OK);
    }
}
