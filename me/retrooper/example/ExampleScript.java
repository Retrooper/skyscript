package me.retrooper.example;

import me.retrooper.skyscript.Runner;

public class ExampleScript {
	
	
	/**
	 * Code:
	 * 
	 *    str name = 'Retrooper';
	 *    num age = 14;
	 *    print('You are called Retrooper and are ' > 4 + 4 * 3 > ' years old');
	 * 
	 */
	public static void main(String[] args) {
		String code = "str name = 'Retrooper'; num age = 14; print('You are called Retrooper and are ' > 4 + 4 * 3 > ' years old');";
		Runner.execute(code);
	}

}
