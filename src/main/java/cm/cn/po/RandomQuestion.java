package cm.cn.po;

/**
 * ����������
 */
public class RandomQuestion {
	private Integer typeId;//��Ŀ���ͣ�1 ��ѡ 2 ��ѡ 3 �жϣ�
	private String leibieType;//A��B��C��
	private Integer exam_type;//������𣬱ؿ���1�����棨2��
	private Integer difficult_type;//�Ծ����׳̶ȣ�1-�ף�2-�У�3-�ѣ�
	private Integer know_type;//֪ʶ��
	private Integer total;//��Ҫ��ѯ����
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getLeibieType() {
		return leibieType;
	}
	public void setLeibieType(String leibieType) {
		this.leibieType = leibieType;
	}
	public Integer getExam_type() {
		return exam_type;
	}
	public void setExam_type(Integer exam_type) {
		this.exam_type = exam_type;
	}
	public Integer getDifficult_type() {
		return difficult_type;
	}
	public void setDifficult_type(Integer difficult_type) {
		this.difficult_type = difficult_type;
	}
	public Integer getKnow_type() {
		return know_type;
	}
	public void setKnow_type(Integer know_type) {
		this.know_type = know_type;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}
