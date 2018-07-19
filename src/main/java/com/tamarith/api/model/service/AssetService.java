package com.tamarith.api.model.service;

import java.util.List;

import com.tamarith.api.model.entity.ActivosSubtipo;;

public interface AssetService {

	public ActivosSubtipo getActivoSubtipo(Integer activoSubtipoId);

	public List<ActivosSubtipo> getActivosSubtipo();
		
}
