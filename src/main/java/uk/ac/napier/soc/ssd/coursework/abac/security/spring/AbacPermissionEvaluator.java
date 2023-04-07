/**
 * This class has been adapted from https://github.com/mostafa-eltaher/AbacSpringSecurity
 */
package uk.ac.napier.soc.ssd.coursework.abac.security.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uk.ac.napier.soc.ssd.coursework.abac.security.policy.PolicyEnforcement;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class AbacPermissionEvaluator implements PermissionEvaluator {
	private static Logger logger = LoggerFactory.getLogger(AbacPermissionEvaluator.class);
	
	@Autowired
	PolicyEnforcement policy;

	@Override
	public boolean hasPermission(Authentication authentication , Object targetDomainObject, Object permission) {
		Object user = authentication.getPrincipal();
		Map<String, Object> environment = new HashMap<>();
		
		environment.put("time", new Date());
		
		logger.debug("hasPersmission({}, {}, {})", user, targetDomainObject, permission);
		return policy.check(user, targetDomainObject, permission, environment);
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		return false;
	}

}
