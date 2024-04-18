package com.ms.user.configs;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "control")
public class ExceptionConfigs {

    private Map<String,String> exception;

    public static final String  BUSINESS ="business";

    public static final String SYSTEM = "system";


    public String getTypeException(final String typeException){
        return  exception.get(typeException);
    }

}
