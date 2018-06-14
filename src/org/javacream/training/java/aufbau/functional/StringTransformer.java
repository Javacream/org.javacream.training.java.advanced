package org.javacream.training.java.aufbau.functional;

import java.util.HashMap;

public class StringTransformer {

	private HashMap<String, StringTransformationAlgorithm> algos = new HashMap<>();

	{
		algos.put("upper", (String e) -> {
			return e.toUpperCase();
		});

	}

	public void register(String name, StringTransformationAlgorithm algo) {
		algos.put(name, algo);
	}

	public String transformString(String toTransform, String algorithmName) {
		if (toTransform == null) {
			throw new IllegalArgumentException("null param");
		}
		System.out.println("Transforming string " + toTransform);
		try {
			String transformedString = algos.get(algorithmName).transform(toTransform);
			return transformedString;
		} catch (NullPointerException e) {
			return "No algo found for " + algorithmName + ", returning untransformed " + toTransform;
		}
	}

	public static void main(String[] args) {
		StringTransformer st = new StringTransformer();
		String input = "Hugo";
		String result = st.transformString(input, "upper");
		System.out.println(result);
		result = st.transformString(input, "lower");
		System.out.println(result);
		st.register("lower", (e) -> e.toLowerCase());
		result = st.transformString(input, "lower");
		System.out.println(result);
	}

}
