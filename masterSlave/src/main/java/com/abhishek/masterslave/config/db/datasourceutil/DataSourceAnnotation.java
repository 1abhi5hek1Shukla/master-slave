package com.abhishek.masterslave.config.db.datasourceutil;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface DataSourceAnnotation {
    DataSourceType value() default DataSourceType.MASTER;
}
