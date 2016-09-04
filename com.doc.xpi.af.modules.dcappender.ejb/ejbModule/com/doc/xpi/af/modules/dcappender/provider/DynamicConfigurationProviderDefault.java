package com.doc.xpi.af.modules.dcappender.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationAttribute;
import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationProvider;
import com.doc.xpi.af.modules.dcappender.util.DynamicConfigurationProviderException;
import com.sap.engine.interfaces.messaging.api.Message;

public class DynamicConfigurationProviderDefault implements
		DynamicConfigurationProvider {

	private static final String PARAMETER_NAMESPACE = "namespace";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_VALUE = "value";

	@Override
	public List<DynamicConfigurationAttribute> execute(Message message,
			Map<String, String> parameters)
			throws DynamicConfigurationProviderException {

		List<DynamicConfigurationAttribute> dcAttributes = new ArrayList<DynamicConfigurationAttribute>();
		DynamicConfigurationAttribute dcAttribute = null;

		String parameterNamespace = null;
		String parameterName = null;
		String parameterValue = null;

		for (Map.Entry<String, String> parameter : parameters.entrySet()) {
			if (parameter.getKey().equals(PARAMETER_NAMESPACE)) {
				parameterNamespace = parameter.getValue();
			} else if (parameter.getKey().equals(PARAMETER_NAME)) {
				parameterName = parameter.getValue();
			} else if (parameter.getKey().equals(PARAMETER_VALUE)) {
				parameterValue = parameter.getValue();
			} else {
				// Reserved for future use
			}
		}

		if (parameterNamespace != null && !parameterNamespace.isEmpty()
				&& parameterName != null && !parameterName.isEmpty()
				&& parameterValue != null && !parameterValue.isEmpty()) {

			dcAttribute = new DynamicConfigurationAttribute(parameterNamespace,
					parameterName, parameterValue);
			if (dcAttribute.isDynamicConfigurationAttributeComplete()) {
				dcAttributes.add(dcAttribute);
			}

		}

		return dcAttributes;
	}

}
