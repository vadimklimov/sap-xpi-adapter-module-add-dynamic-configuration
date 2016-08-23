package com.doc.xpi.af.modules.dcappender.util;

public class DynamicConfigurationAttribute {

	public String namespace;
	public String name;
	public String value;

	public DynamicConfigurationAttribute(String namespace, String name,
			String value) {
		this.namespace = namespace;
		this.name = name;
		this.value = value;
	}

	public boolean isDynamicConfigurationAttributeComplete() {
		return (this.getNamespace() != null && !this.getNamespace().isEmpty()
				&& this.getName() != null && !this.getName().isEmpty()
				&& this.getValue() != null && !this.getValue().isEmpty()) ? true
				: false;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}