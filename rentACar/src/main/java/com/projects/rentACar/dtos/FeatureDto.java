package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeatureDto {

    private Integer featureId;
    private String feature;

    public FeatureDto(){}

    private FeatureDto(Builder builder){
        this.featureId = builder.featureId;
        this.feature= builder.feature;;
    }

    public static class Builder {

        private Integer featureId;
        private String feature;

        public Builder(){}

        public Builder(FeatureDto carFeatureDto){
            this.featureId = carFeatureDto.featureId;
            this.feature = carFeatureDto.getFeature();
        }

        public Builder featureId(Integer featureId){
            this.featureId = featureId;
            return this;
        }

        public Builder feature(String feature){
            this.feature = feature;
            return this;
        }

        public FeatureDto build(){
            return new FeatureDto(this);
        }
    }
}
