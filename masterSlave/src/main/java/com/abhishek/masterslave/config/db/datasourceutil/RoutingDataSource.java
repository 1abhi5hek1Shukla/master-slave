package com.abhishek.masterslave.config.db.datasourceutil;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceContextHolder.getDataSourceType();
        if(dataSourceType == null){
            dataSourceType = DataSourceType.MASTER;
        }
        return dataSourceType;
    }
}
