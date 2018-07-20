package com.tamarith.api.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamarith.api.model.entity.ActivosTipo;


public interface AssetDAO extends JpaRepository<ActivosTipo, Integer>{

}
