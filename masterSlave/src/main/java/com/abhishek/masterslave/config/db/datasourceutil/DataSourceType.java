package com.abhishek.masterslave.config.db.datasourceutil;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataSourceType {
    MASTER("master"),
    SLAVE("slave");

    private final String value;
}
