package cm.cn.mapper;

import java.util.List;

public interface ExampaperMapper {
	//���� id ����ɾ���Ծ�
	public int delByIdArray(String[] intarray);
	//���� �㼶��ѯ�Ծ� id ����
	public List<String> findByLevel(String reserveSix);
}
