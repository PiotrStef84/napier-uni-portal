/**
 * This class has been adapted from https://github.com/mostafa-eltaher/AbacSpringSecurity
 */
package uk.ac.napier.soc.ssd.coursework.abac.security.policy.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.io.IOException;

public class SpelDeserializer extends StdDeserializer<Expression> {
	private static final long serialVersionUID = -3756824333350261220L;
	
	ExpressionParser elParser = new SpelExpressionParser();
	
	public SpelDeserializer(){
		this(null);
	}

	protected SpelDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Expression deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String expresionString = jp.getCodec().readValue(jp, String.class);
        return elParser.parseExpression(expresionString);
	}

}
