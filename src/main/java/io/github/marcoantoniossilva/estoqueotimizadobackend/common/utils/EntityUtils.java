package io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class EntityUtils <ENTITY>{
    ModelMapper modelMapper = new ModelMapper();

    public ENTITY merge(ENTITY source,ENTITY target){
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, target);
        return target;
    }
}
