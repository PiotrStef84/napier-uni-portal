/**
 * This class has been adapted from https://github.com/mostafa-eltaher/AbacSpringSecurity
 */
package uk.ac.napier.soc.ssd.coursework.abac.security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uk.ac.napier.soc.ssd.coursework.abac.security.policy.PolicyEnforcement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ContextAwarePolicyEnforcement {
	@Autowired
	protected PolicyEnforcement policy;
	
	public void checkPermission(Object resource, String permission) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Map<String, Object> environment = new HashMap<>();
		
		environment.put("time", new Date());
		
		if(!policy.check(auth.getPrincipal(), resource, permission, environment))
			throw new AccessDeniedException("Access is denied");
	}
}
