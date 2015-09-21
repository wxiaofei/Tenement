package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.RepairRecord;

public interface IRepairRecordDao 
{
	/**
	 * �������޼�¼
	 * @param repairrecord
	 * @return
	 */
	public abstract boolean addRepairRecord(RepairRecord repairrecord);
	
	
	/**
	 * �޸ı��޼�¼��
	 * @param repairrecord
	 * @return
	 */
	public abstract boolean modifyRepairRecord(RepairRecord repairrecord);
	
	/**
	 * �鿴���б��޼�¼
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findAllRepairRecord();
	
	
	/**
	 * ���ݱ���id���ұ���
	 * @return
	 */
	public abstract RepairRecord findRepairRecordByRepairid(int repairid);
	
	/**
	 * ����ҵ��id���ұ��޼�¼�����ܷ��ض�����¼
	 * @param identity
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findRepairRecordByIdentity(String identity);
	
	/**
	 * ����״̬state���ұ��޼�¼
	 * @param state
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findRepairRecordByState(int state);
	
	
}
