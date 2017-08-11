package cm.cn.po;

/**
 * 用于随机组卷
 */
public class RandomQuestion {
	private Integer typeId;//题目类型（1 单选 2 多选 3 判断）
	private String leibieType;//A，B，C类
	private Integer exam_type;//考试类别，必考（1）常规（2）
	private Integer difficult_type;//试卷难易程度（1-易，2-中，3-难）
	private Integer know_type;//知识点
	private Integer total;//需要查询总数
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
