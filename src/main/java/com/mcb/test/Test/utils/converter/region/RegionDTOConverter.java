package com.mcb.test.Test.utils.converter.region;

import com.mcb.test.Test.model.collection.location.Region;
import com.mcb.test.Test.model.dto.region.RegionListElementDTO;

import java.util.ArrayList;
import java.util.List;

public class RegionDTOConverter {

    public static RegionListElementDTO entityToDTO(Region region) {
        RegionListElementDTO regionDto = null;
        if (region != null) {
            regionDto = new RegionListElementDTO();
            regionDto.setRegionId(region.getId());
            regionDto.setRegionName(region.getRegion());
        }
        return regionDto;
    }

    public static List<RegionListElementDTO> entityListToDTO(List<Region> regions) {
        List<RegionListElementDTO> regionListDto = null;
        if (regions != null) {
            if (regions.size() > 0) {
                regionListDto = new ArrayList<RegionListElementDTO>();
                for (Region regionTemp : regions) {
                    regionListDto.add(RegionDTOConverter.entityToDTO(regionTemp));
                }
            }
        }
        return regionListDto;
    }
}
