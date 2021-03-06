package com.x.portal.assemble.designer.jaxrs.script;

import com.x.base.core.exception.PromptException;

class InsufficientPermissionException extends PromptException {

	private static final long serialVersionUID = -9089355008820123519L;

	InsufficientPermissionException(String person) {
		super("person: {} has insufficient permission.", person);
	}
}
