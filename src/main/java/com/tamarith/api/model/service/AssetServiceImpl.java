package com.tamarith.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamarith.api.model.dao.AssetDAO;
import com.tamarith.api.model.entity.ActivosTipo;

@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetDAO assetDAO;
	
	@Override
	@Transactional(readOnly=true)
	public ActivosTipo getActivoTipo(Integer activoTipoId) {		
		return assetDAO.findById(activoTipoId).get();
	}

	@Override
	@Transactional(readOnly=true)
	public List<ActivosTipo> getActivosTipo() {
		return (List<ActivosTipo>) assetDAO.findAll();
	}

}
