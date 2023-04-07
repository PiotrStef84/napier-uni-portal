/**
 * This class has been adapted from https://github.com/mostafa-eltaher/AbacSpringSecurity
 */
package uk.ac.napier.soc.ssd.coursework.abac.security.policy;

import java.util.List;

public interface PolicyDefinition {
	public List<PolicyRule> getAllPolicyRules();
}
