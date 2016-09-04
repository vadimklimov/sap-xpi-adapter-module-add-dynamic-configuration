package com.doc.xpi.af.modules.dcappender.util;

import com.sap.engine.interfaces.messaging.api.MessageKey;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccessFactory;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditAccess;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditLogStatus;
import com.sap.engine.interfaces.messaging.api.exception.MessagingException;

public class AuditLogHelper {

	private MessageKey messageKey;
	private AuditAccess audit;

	public AuditLogHelper(MessageKey messageKey) {

		this.messageKey = messageKey;

		try {
			this.audit = PublicAPIAccessFactory.getPublicAPIAccess()
					.getAuditAccess();
		} catch (MessagingException e) {
		}

	}

	public void addAuditLogEntry(AuditLogStatus status, String text) {

		if (this.audit != null) {
			this.audit.addAuditLogEntry(this.messageKey, status, text);
		}

	}

}
