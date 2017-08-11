package cm.cn.po;

import java.util.List;

public class CaseAndQuestion {
	private int myId ;
	private List<JsCasequestion> list;
	private JsCase jsCase ;
	public List<JsCasequestion> getList() {
		return list;
	}
	public void setList(List<JsCasequestion> list) {
		this.list = list;
	}
	public JsCase getJsCase() {
		return jsCase;
	}
	public void setJsCase(JsCase jsCase) {
		this.jsCase = jsCase;
	}
	public int getMyId() {
		return myId;
	}
	public void setMyId(int myId) {
		this.myId = myId;
	}
}
