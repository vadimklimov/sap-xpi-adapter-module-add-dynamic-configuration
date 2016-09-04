package com.doc.xpi.af.modules.dcappender.util;

import java.lang.reflect.InvocationTargetException;

public class DynamicConfigurationProviderFactory {

	private static final String PROVIDER_CLASS_SUBPACKAGE = "provider";
	private static final String PROVIDER_DEFAULT_CLASS_NAME = "DynamicConfigurationProviderDefault";

	public DynamicConfigurationProvider getDynamicConfigurationProvider(
			String dcProviderType, String dcProviderClassName)
			throws DynamicConfigurationProviderFactoryException {

		if (dcProviderType
				.equals(DynamicConfigurationProviderType.DC_PROVIDER_DEFAULT)) {
			dcProviderClassName = PROVIDER_DEFAULT_CLASS_NAME;
		}

		DynamicConfigurationProvider dcProvider = this
				.getDynamicConfigurationProviderClass(dcProviderClassName);

		if (dcProvider != null) {
			return dcProvider;
		} else {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider");
		}

	}

	private DynamicConfigurationProvider getDynamicConfigurationProviderClass(
			String className)
			throws DynamicConfigurationProviderFactoryException {

		String factoryPackageName = this.getClass().getPackage().getName();
		String classPackageName = factoryPackageName.substring(0,
				factoryPackageName.lastIndexOf('.'))
				+ "." + PROVIDER_CLASS_SUBPACKAGE;
		String classCanonicalName = classPackageName + "." + className;

		try {
			Class<?> classDcProvider = Class.forName(classCanonicalName);
			DynamicConfigurationProvider dcProvider = (DynamicConfigurationProvider) classDcProvider
					.getConstructor().newInstance();
			return dcProvider;
		} catch (ClassNotFoundException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (SecurityException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (InstantiationException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (InvocationTargetException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			throw new DynamicConfigurationProviderFactoryException(
					"Error when accessing dynamic configuration provider: "
							+ e.getMessage(), e);
		}

	}

}
