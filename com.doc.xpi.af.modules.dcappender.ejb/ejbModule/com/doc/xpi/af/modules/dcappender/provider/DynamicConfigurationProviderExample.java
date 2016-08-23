package com.doc.xpi.af.modules.dcappender.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationAttribute;
import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationProvider;
import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationProviderException;
import com.sap.engine.interfaces.messaging.api.Message;

public class DynamicConfigurationProviderExample implements
		DynamicConfigurationProvider {

	@Override
	public List<DynamicConfigurationAttribute> execute(Message message,
			Map<String, String> parameters)
			throws DynamicConfigurationProviderException {

		List<DynamicConfigurationAttribute> dcAttributes = new ArrayList<DynamicConfigurationAttribute>();

		DynamicConfigurationProvider dcProvider = new DynamicConfigurationProviderDefault();
		dcAttributes = dcProvider.execute(message, parameters);

		return dcAttributes;

	}

}
