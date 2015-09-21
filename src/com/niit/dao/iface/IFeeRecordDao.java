package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.FeeRecord;

public interface IFeeRecordDao
{
	/**
	 * �����ɷѼ�¼
	 */
	public abstract boolean addFeeRecord(FeeRecord feerecord);
	
	/**
	 * �޸ĽɷѼ�¼,ֻ���޸�״̬state��ͨ��ʱ��examtime
	 * @param feeid
	 * @return
	 */
	public abstract boolean modifyFeeRecord(FeeRecord feerecord);
	
	/**
	 * �������нɷѼ�¼
	 * @return
	 */
	public abstract ArrayList<FeeRecord> findAllFeeRecord();
	
	/**
	 * ���ݱ�Ų��ҽɷѼ�¼
	 */
	public abstract FeeRecord findFeeRecordByFeeid(int feeid);
	
	/**
	 * ����identity���ҽɷѼ�¼�����ض�����¼
	 */
	public abstract ArrayList<FeeRecord> findFeeRecordByIdentity(String identity);
	
	/**
	 * ����pass����
	 */
	public abstract ArrayList<FeeRecord> findFeeRecordByPass(int pass);
	
	
	
}
