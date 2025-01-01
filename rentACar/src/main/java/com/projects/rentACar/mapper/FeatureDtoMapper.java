package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.FeatureDto;
import com.projects.rentACar.entities.Feature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeatureDtoMapper {

    public FeatureDto map(Feature feature){

        return new FeatureDto.Builder()
//                .featureId(feature.getFeatureId())
                .feature(feature.getFeature())
                .build();
    }

    public List<FeatureDto> mapList(List<Feature> features){
        List<FeatureDto> featureDtoList = new ArrayList<>();
        for(Feature feature : features){
            featureDtoList.add(this.map(feature));
        }
        return featureDtoList;
    }

    public Feature convertToEntity(FeatureDto featureDto){
        Feature feature = new Feature();
        feature.setFeatureId(featureDto.getFeatureId());
        feature.setFeature(featureDto.getFeature().trim().toUpperCase());
        return feature;
    }

    public Feature convertToEntityByOnlyId(FeatureDto featureDto){
        Feature feature = new Feature();
        feature.setFeatureId(featureDto.getFeatureId());
        return feature;
    }
}
