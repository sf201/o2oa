package com.x.processplatform.assemble.surface.jaxrs.applicationdict;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.http.ActionResult;
import com.x.base.core.http.WrapOutId;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.core.entity.element.Application;
import com.x.processplatform.core.entity.element.ApplicationDict;

class ActionCreateDataPath2 extends ActionBase {

	ActionResult<WrapOutId> execute(String applicationDictFlag, String applicationFlag, String path0, String path1,
			String path2, JsonElement jsonElement) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			ActionResult<WrapOutId> result = new ActionResult<>();
			Business business = new Business(emc);
			Application application = business.application().pick(applicationFlag);
			if (null == application) {
				throw new ApplicationNotExistException(applicationFlag);
			}
			String id = business.applicationDict().getWithApplicationWithUniqueName(application.getId(),
					applicationDictFlag);
			if (StringUtils.isEmpty(id)) {
				throw new ApplicationDictNotExistException(applicationFlag);
			}
			ApplicationDict dict = emc.find(id, ApplicationDict.class);
			this.create(business, dict, jsonElement, path0, path1, path2);
			emc.commit();
			WrapOutId wrap = new WrapOutId(dict.getId());
			result.setData(wrap);
			return result;
		}
	}
}