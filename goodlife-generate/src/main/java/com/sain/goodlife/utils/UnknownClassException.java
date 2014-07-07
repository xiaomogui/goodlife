package com.sain.goodlife.utils;

import com.sain.goodlife.GoodlifeException;

/**
 * 参考shiro
 * @author sain
 *
 */
@SuppressWarnings("serial")
public class UnknownClassException extends GoodlifeException {

	public UnknownClassException() {
		super();
	}

	public UnknownClassException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownClassException(String message) {
		super(message);
	}

	public UnknownClassException(Throwable cause) {
		super(cause);
	}

}
