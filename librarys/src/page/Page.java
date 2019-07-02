package page;

import java.util.List;

public class Page {
	private int pageSize = 3;	//一个分页显示5个数据
	private List items;
	private int pageNum;	//当前页数
	private int totalPageSize;	//一共有多少页
	private int startIndex;		//每页开始的第一个item的索引
	private int totalItemNum;
	private int prePageNum;
	private int nextPageNum;
	private String url;
	
	public Page(int pageNum,int totalItemNum) {
		this.pageNum = pageNum;
		this.totalItemNum = totalItemNum;
		if(totalItemNum%pageSize == 0) {
			totalPageSize = totalItemNum/pageSize;
		}else {
			totalPageSize = totalItemNum/pageSize + 1;
		}
		
		startIndex = (pageNum - 1)*pageSize;
		if(pageNum - 1 < 1) {
			prePageNum = 1;
		}else {
			prePageNum = pageNum - 1;
		}
		if(pageNum + 1 > totalPageSize) {
			nextPageNum = totalPageSize;
		}else {
			nextPageNum = pageNum + 1;
		}
	}

	public Page(int pageNum,int totalItemNum,int pageSize) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.totalItemNum = totalItemNum;
		if(totalItemNum%pageSize == 0) {
			totalPageSize = totalItemNum/pageSize;
		}else {
			totalPageSize = totalItemNum/pageSize + 1;
		}
		
		startIndex = (pageNum - 1)*pageSize;
		if(pageNum - 1 < 1) {
			prePageNum = 1;
		}else {
			prePageNum = pageNum - 1;
		}
		if(pageNum + 1 > totalPageSize) {
			nextPageNum = totalPageSize;
		}else {
			nextPageNum = pageNum + 1;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalItemNum() {
		return totalItemNum;
	}

	public void setTotalItemNum(int totalItemNum) {
		this.totalItemNum = totalItemNum;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
