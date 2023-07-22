package com.xchangeapp.fxrateservice.repository;

import com.xchangeapp.fxrateservice.data.FxRate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxRateRepository extends ElasticsearchRepository<FxRate, String> {
    
}
