package com.xchangeapp.fxrateservice.repository;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import com.xchangeapp.fxrateservice.data.FxRate;
import com.xchangeapp.fxrateservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class FxRateRepository {

    private final ElasticsearchAsyncClient elasticsearchAsyncClient;

    @Async
    public void save(FxRate fxRate) {
        elasticsearchAsyncClient.index(indexRequest -> indexRequest
                .index(Constant.INDEX_FX_RATES)
                .document(fxRate)
        ).whenComplete((response, exception) -> {
            if (exception != null) {
                log.error("Failed to index: ", exception);
            } else {
                log.info("Indexed with version: " + response.version());
            }
        });
    }

}
