package com.zzp.base.results;

/**
 * 分页API Response
 * @author Garyzeng
 * @since 2019.12.27
 */
public class PageResult<T> extends Result<T>{
	/**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;
    
    /**
     * 总数，当 total 不为 0 时分页插件不会进行 count 查询
     */
    private long total = 0;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	/**
     * <p>
     * 是否存在上一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * <p>
     * 是否存在下一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }
    
    /**
     * <p>
     * 当前分页总页数
     * </p>
     */
    private long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }
	
	public static <T> PageResult<T> ok(T data) {
        return restResult(data, 0, "", true);
    }
	
	public static <T> PageResult<T> ok(String msg, T data) {
        return restResult(data, 0, msg, true);
    }

    public static <T> PageResult<T> failed(String msg) {
        return restResult(null, -1, msg, false);
    }

    private static <T> PageResult<T> restResult(T data, Integer status, String msg, Boolean ok) {
    	PageResult<T> apiResult = new PageResult<>();
        apiResult.setStatus(status);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setOk(ok);
        
        return apiResult;
    }
}
