

package com.wyzy.hospital.manager.api.service.impl;

import com.wyzy.hospital.manager.api.service.ApiModelService;
import com.wyzy.hospital.manager.manager.ModelInfoManager;
import com.wyzy.hospital.manager.model.ModelInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LCN on 2017/11/13
 * @author LCN
 */
@Service
public class ApiModelServiceImpl implements ApiModelService {

	@Override
	public List<ModelInfo> onlines() {
		return ModelInfoManager.getInstance().getOnlines();
	}

}
