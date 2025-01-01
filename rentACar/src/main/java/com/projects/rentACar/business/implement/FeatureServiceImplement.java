package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.FeatureService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.FeatureDto;
import com.projects.rentACar.entities.Feature;
import com.projects.rentACar.mapper.FeatureDtoMapper;
import com.projects.rentACar.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureServiceImplement implements FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureDtoMapper featureDtoMapper;

    @Override
    public DataResult<FeatureDto> add(FeatureDto featureDto) {
        return new SuccessDataResult<>(featureDtoMapper.map(featureRepository.save(featureDtoMapper.convertToEntity(featureDto))), "Özellik eklendi");
    }

    @Override
    public DataResult<List<FeatureDto>> getAllCar() {
        return new SuccessDataResult<>(featureDtoMapper.mapList(featureRepository.findAll()), "Araç özellikleri listelendi");
    }

    @Override
    public DataResult<FeatureDto> update(FeatureDto featureDto) {
        Feature resultFeature =  featureRepository.findByFeatureId(featureDto.getFeatureId());
        if(resultFeature == null){
            throw new NullPointerException("Özellik bulunamadı");
        }
        return new SuccessDataResult<>(featureDtoMapper.map(featureRepository.save(featureDtoMapper.convertToEntity(featureDto))), "Özellik güncellendi");
    }

    @Override
    public Result delete(Integer featureId) {
        Feature feature = featureRepository.findByFeatureId(featureId);
        if(feature == null){
            return new ErrorResult("Bu idye sahip bir özellik bulunamadı");
        }
        featureRepository.deleteById(featureId);
        return new SuccessResult("Özellik başarıyla silindi");
    }

    @Override
    public DataResult<FeatureDto> findByFeature(String feature) {
        Feature resultFeature = featureRepository.findByFeature(feature);
        if(resultFeature == null){
            return new ErrorDataResult<>(null, "Bu özellikle sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(featureDtoMapper.map(featureRepository.findByFeature(feature)), "Özellik getirildi");
    }
}
