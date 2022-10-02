package com.mcb.test.Test.service.region;

import com.mcb.test.Test.model.dto.region.RegionListElementDTO;
import com.mcb.test.Test.repository.region.RegionRepository;
import com.mcb.test.Test.utils.converter.region.RegionDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionListElementDTO> getAllRegions() {
        return RegionDTOConverter.entityListToDTO(this.regionRepository.findAll());
    }
}
