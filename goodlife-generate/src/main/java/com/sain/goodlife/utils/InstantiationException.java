package com.sain.goodlife.utils;

import com.sain.goodlife.GoodlifeException;

/**
 * 参考shiro
 * 
 * @author sain
 * 
 */
@SuppressWarnings("serial")
public class InstantiationException extends GoodlifeException {

	public InstantiationException() {
		super();
	}

	public InstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstantiationException(String message) {
		super(message);
	}

	public InstantiationException(Throwable cause) {
		super(cause);
	}

}
