package com.sain.goodlife;

/**
 * 参考shiro的ShiroException
 * @author sain
 *
 */
@SuppressWarnings("serial")
public class GoodlifeException extends RuntimeException {

	public GoodlifeException() {
		super();
	}

	public GoodlifeException(String message, Throwable cause) {
		super(message, cause);
	}

	public GoodlifeException(String message) {
		super(message);
	}

	public GoodlifeException(Throwable cause) {
		super(cause);
	}

}
