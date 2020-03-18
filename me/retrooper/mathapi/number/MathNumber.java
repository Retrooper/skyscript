package me.retrooper.mathapi.number;

import me.retrooper.mathapi.number.enums.NumberType;
/**
 * @author Retrooper
 */
public class MathNumber {
	private double val;
	private NumberType type;
	public MathNumber(double val, NumberType type) {
		this.val = val;
		this.type = type;
	}
	
	public void setValue(double val) {
		this.val = val;
	}
	
	public double getValue() {
		return val;
	}
	
	
	public void setIntValue(int val) {
		this.val = val;
	}
	
	public int getIntValue() {
		return (int)val;
	}

	public NumberType getType() {
		return type;
	}
}
