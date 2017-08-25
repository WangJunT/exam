package cm.cn.po;

import java.util.List;

public class Page<T> {
	private int pageSize;//ÿҳ��ʾ����������
	private int currentPage;//��ǰ�ڼ�ҳ����
	private int totalRecord;//һ������������
	private int totalPage;//һ������ҳ
	private List<T> dataList;//Ҫ��ʾ������
	
	public Page() {
		super();
	}

	public Page(int pageNum, int pageSize,List<T> sourceList){
		if(sourceList == null){
			return;
		}
		//�ܼ�¼��
		this.totalRecord = sourceList.size();
		//ÿҳ��ʾ��������¼
		this.pageSize = pageSize;
		//��ȡ��ҳ��
		this.totalPage = this.totalRecord/this.pageSize;
		if(this.totalRecord%this.pageSize!=0){
			this.totalPage = this.totalPage + 1;
		}
		//��ǰ�ڼ�ҳ����
		if(this.totalPage < pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage = pageNum;
		}
		
		//��ʼ����
		int fromIndex = this.pageSize * (this.currentPage - 1);
		//��������
		int toIndex;
		if(this.pageSize * this.currentPage > this.totalRecord){
			toIndex = this.totalRecord;
		}else{
			toIndex = this.pageSize * this.currentPage;
		}
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}

	public Page(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}