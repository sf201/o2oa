package com.x.okr.assemble.control.jaxrs.okrtaskhandled.exception;

import com.x.base.core.exception.PromptException;

public class TaskHandledNotExistsException extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	public TaskHandledNotExistsException( String id ) {
		super("指定的已办信息不存在!ID:" + id );
	}
	
}
