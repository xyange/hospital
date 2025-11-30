package com.wyzy.hospital.app.producerConsumer;

import com.wyzy.hospital.app.api.entity.HospitalEs;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author aqie
 * Date on 2021/5/21  11:46
 * @Function:
 */
public class HospitalBlock extends ArrayBlockingQueue<List<HospitalEs>> {
	public HospitalBlock(int capacity) {
		super(capacity);
	}

	/**
	 * mysql 查询医院列表数据
	 * @param list
	 * @throws InterruptedException
	 */
	@Override
	public void put(List<HospitalEs> list) throws InterruptedException {
		super.put(list);
	}

	/**
	 * 数据插入到es
	 * @return
	 * @throws InterruptedException
	 */
	@Override
	public List<HospitalEs> take() throws InterruptedException {
		List<HospitalEs> take = super.take();
		return take;
	}
}
