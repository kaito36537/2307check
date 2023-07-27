package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.WeightEntity;
import com.example.demo.Repository.WeightRepository;

@Service
public class WeightService {
    @Autowired
    private WeightRepository weightRepository;

    // 体重情報の一覧を取得する
    public List<WeightEntity> getAllWeights() {
        return weightRepository.findAll();
    }

    // 体重情報を保存する
    public void saveWeight(WeightEntity weight) {
        weightRepository.save(weight);
    }

    // 特定のIDの体重情報を取得する
    public WeightEntity getWeightById(Long id) {
        return weightRepository.findById(id).orElse(null);
    }

    // 特定のIDの体重情報を削除する
    public void deleteWeightById(Long id) {
        weightRepository.deleteById(id);
    }
}
