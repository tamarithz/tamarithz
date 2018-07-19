package com.tamarith.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamarith.api.model.dao.AssetDAO;
import com.tamarith.api.model.entity.ActivosSubtipo;

@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetDAO assetDAO;
	
	@Override
	@Transactional(readOnly=true)
	public ActivosSubtipo getActivoSubtipo(Integer activoSubtipoId) {		
		return assetDAO.findById(activoSubtipoId).get();
	}

	@Override
	@Transactional(readOnly=true)
	public List<ActivosSubtipo> getActivosSubtipo() {
		return (List<ActivosSubtipo>) assetDAO.findAll();
	}

}
