package com.mcb.test.Test.repository.region;

import com.mcb.test.Test.model.collection.location.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends MongoRepository<Region, String> {
    public Boolean existsByRegion(String region);
}
