package cm.cn.service;

import java.util.List;


public interface CaseService {
	//���ݲ㼶���Ҽ����
	public List<String> findByLevel(String reserveSix);
	//���� id ����ɾ�������
	public int delByIdArray(String[] array);
}
