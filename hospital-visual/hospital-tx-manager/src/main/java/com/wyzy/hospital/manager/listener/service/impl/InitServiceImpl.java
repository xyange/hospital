

package com.wyzy.hospital.manager.listener.service.impl;

import com.wyzy.hospital.manager.config.ConfigReader;
import com.wyzy.hospital.manager.framework.utils.Constants;
import com.wyzy.hospital.manager.listener.service.InitService;
import com.wyzy.hospital.manager.netty.service.NettyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LCN on 2017/7/4.
 */
@Service
public class InitServiceImpl implements InitService {

	@Autowired
	private NettyServerService nettyServerService;

	@Autowired
	private ConfigReader configReader;

	@Override
	public void start() {
		/** 加载本地服务信息 **/

		Constants.socketPort = configReader.getSocketPort();
		Constants.maxConnection = configReader.getSocketMaxConnection();
		nettyServerService.start();
	}

	@Override
	public void close() {
		nettyServerService.close();
	}

}
