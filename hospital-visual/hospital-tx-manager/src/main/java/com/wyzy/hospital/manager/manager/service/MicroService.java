

package com.wyzy.hospital.manager.manager.service;

import com.wyzy.hospital.manager.model.TxServer;
import com.wyzy.hospital.manager.model.TxState;

/**
 * @author LCN on 2017/11/11
 */
public interface MicroService {

	String TMKEY = "tx-manager";

	TxServer getServer();

	TxState getState();

}
