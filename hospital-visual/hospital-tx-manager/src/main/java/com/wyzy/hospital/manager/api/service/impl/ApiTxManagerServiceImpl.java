

package com.wyzy.hospital.manager.api.service.impl;

import com.wyzy.hospital.manager.api.service.ApiTxManagerService;
import com.wyzy.hospital.manager.compensate.model.TransactionCompensateMsg;
import com.wyzy.hospital.manager.compensate.service.CompensateService;
import com.wyzy.hospital.manager.config.ConfigReader;
import com.wyzy.hospital.manager.manager.service.MicroService;
import com.wyzy.hospital.manager.manager.service.TxManagerSenderService;
import com.wyzy.hospital.manager.manager.service.TxManagerService;
import com.wyzy.hospital.manager.model.TxServer;
import com.wyzy.hospital.manager.model.TxState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author LCN on 2017/7/1.
 * @author LCN
 * @author wyzy
 */
@Service
@AllArgsConstructor
public class ApiTxManagerServiceImpl implements ApiTxManagerService {

	private final TxManagerService managerService;

	private final MicroService eurekaService;

	private final CompensateService compensateService;

	private final TxManagerSenderService txManagerSenderService;

	private final ConfigReader configReader;

	@Override
	public TxServer getServer() {
		return eurekaService.getServer();
	}

	@Override
	public int cleanNotifyTransaction(String groupId, String taskId) {
		return managerService.cleanNotifyTransaction(groupId, taskId);
	}

	@Override
	public boolean sendCompensateMsg(long currentTime, String groupId, String model, String address, String uniqueKey,
			String className, String methodStr, String data, int time, int startError) {
		TransactionCompensateMsg transactionCompensateMsg = new TransactionCompensateMsg(currentTime, groupId, model,
				address, uniqueKey, className, methodStr, data, time, 0, startError);
		return compensateService.saveCompensateMsg(transactionCompensateMsg);
	}

	@Override
	public String sendMsg(String model, String msg) {
		return txManagerSenderService.sendMsg(model, msg, configReader.getTransactionNettyDelayTime());
	}

	@Override
	public TxState getState() {
		return eurekaService.getState();
	}

}
