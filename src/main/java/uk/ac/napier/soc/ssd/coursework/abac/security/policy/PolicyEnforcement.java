/**
 * This class has been adapted from https://github.com/mostafa-eltaher/AbacSpringSecurity
 */
package uk.ac.napier.soc.ssd.coursework.abac.security.policy;

public interface PolicyEnforcement {

	boolean check(Object subject, Object resource, Object action, Object environment);

}
