package me.retrooper.example;

import me.retrooper.mathapi.MathHelper;
import me.retrooper.skyscript.Runner;

public class ExampleScript {
	
	
	/**
	 * Code:
	 * 
	 *    str name = 'Retrooper';
	 *    num age = 14;
	 *    print(name > ' is ' > age > ' years old!');
	 *    print('This is a print message');
	 * 
	 */

	/**
	 * Output:
	 * [SKYSCRIPT]: Retrooper is 14 years old!
	 * [SKYSCRIPT]: This is a print message
	 */
	
	public static void main(String[] args) {
		String code = "str name = 'Retrooper'; num age = 14; print(name > ' is ' > age > ' years old!'); print('This is a print message');";
		MathHelper.silentMode = true;
		MathHelper.prepare();

		Runner.execute(code);
	}

}
