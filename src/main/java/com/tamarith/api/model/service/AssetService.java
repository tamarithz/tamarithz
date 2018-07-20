package com.tamarith.api.model.service;

import java.util.List;

import com.tamarith.api.model.entity.ActivosTipo;;

public interface AssetService {

	public ActivosTipo getActivoTipo(Integer activoTipoId);

	public List<ActivosTipo> getActivosTipo();
		
}
