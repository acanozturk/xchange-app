package com.xchangeapp.fxrateservice.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "fx-rate")
@Data
@Builder
public final class FxRate {
    
    @Id
    private String id;
    
    @Field(name = "base_currency", type = FieldType.Text)
    private String baseCurrency;

    @Field(name = "fx_rates", type = FieldType.Text)
    private String fxRates;

    @CreatedDate
    @Field(name = "created_date", type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant createdDate;
    
}
