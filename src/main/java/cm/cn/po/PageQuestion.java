package cm.cn.po;
/**
 * 用于前端分页显示查询
 */
public class PageQuestion {
	private Integer typeId;//题目类型（1 单选 2 多选 3 判断）
	private String leibieType;//A，B，C类
	private Integer exam_type;//考试类别，必考（1）常规（2）
	private Integer difficult_type;//试卷难易程度（1-易，2-中，3-难）
	private Integer know_type;//知识点
	private Integer start;//limit 前一个字段
	private Integer size;//limit  后一个字段
	private String reserveFive;
	private String reserveSix;
	public String getReserveFive() {
		return reserveFive;
	}
	public void setReserveFive(String reserveFive) {
		this.reserveFive = reserveFive;
	}
	public String getReserveSix() {
		return reserveSix;
	}
	public void setReserveSix(String reserveSix) {
		this.reserveSix = reserveSix;
	}
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
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
