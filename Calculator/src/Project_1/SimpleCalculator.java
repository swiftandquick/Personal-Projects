package Project_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/** 
 * Percentage is not working correctly.  
 * */

@SuppressWarnings("serial")
public class SimpleCalculator extends JFrame implements ActionListener {

	JButton zero = new JButton("0");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");

	JButton add = new JButton("+");
	JButton subtract = new JButton("-");
	JButton multiply = new JButton("*");
	JButton divide = new JButton("/");

	JButton equal = new JButton("=");
	JButton point = new JButton(".");
	
	JButton onOff = new JButton("On / Off");
	JButton clear = new JButton("C");
	JButton allClear = new JButton("AC");
	
	JButton negPos = new JButton("+/-"); // Negative / Positive
	JButton power = new JButton("a^b");
	JButton root = new JButton("\u221A"); // Unicode
	JButton pi = new JButton("\u03C0");
	
	JTextField display = new JTextField("", 12); // Number
	Font font = new Font("Digital-7", Font.BOLD, 20);
	
	String operator = "";
	double num1 = 0;
	double num2 = 0;
	
	
	SimpleCalculator() {
		super("Simple Calculator");
		setSize(300, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);
		
		JPanel row1 = new JPanel();
		FlowLayout row1L = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row1.setLayout(row1L);
		display.setFont(font);
		display.setEnabled(false);
		row1.add(display);
		add(row1);
		
		JPanel row2 = new JPanel();
		FlowLayout row2L = new FlowLayout(FlowLayout.RIGHT, 10, 10);
		row2.setLayout(row2L);
		clear.addActionListener(this);
		allClear.addActionListener(this);
		onOff.addActionListener(this);
		row2.add(clear);
		row2.add(allClear);
		row2.add(onOff);
		add(row2);
		
		JPanel row3 = new JPanel();
		FlowLayout row3L = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row3.setLayout(row3L);
		negPos.addActionListener(this);
		power.addActionListener(this);
		root.addActionListener(this);
		pi.addActionListener(this);
		row3.add(negPos);
		row3.add(power);
		row3.add(root);
		row3.add(pi);
		add(row3);
		
		JPanel row4 = new JPanel();
		FlowLayout row4L = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row4.setLayout(row4L);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		divide.addActionListener(this);
		row4.add(seven);
		row4.add(eight);
		row4.add(nine);
		row4.add(divide);
		add(row4);
		
		JPanel row5 = new JPanel();
		FlowLayout row5L = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row5.setLayout(row5L);		
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		multiply.addActionListener(this);
		row5.add(four);
		row5.add(five);
		row5.add(six);
		row5.add(multiply);
		add(row5);
		
		JPanel row6 = new JPanel();
		FlowLayout row6L = new FlowLayout(FlowLayout.CENTER, 10, 10); 
		row6.setLayout(row6L);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		subtract.addActionListener(this);
		row6.add(one);
		row6.add(two);
		row6.add(three);
		row6.add(subtract);
		add(row6);
		
		JPanel row7 = new JPanel();
		FlowLayout row7L = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row7.setLayout(row7L);
		zero.addActionListener(this);
		point.addActionListener(this);
		equal.addActionListener(this);
		add.addActionListener(this);
		row7.add(zero);
		row7.add(point);
		row7.add(equal);
		row7.add(add);
		add(row7);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		
		String displayText = display.getText();

		if (cmd.equals("On / Off") && displayText.equals("")) {
			display.setText("0"); // On
		}
		else if (cmd.equals("On / Off") && !displayText.equals("")) {
			display.setText(""); // Off
			Reset();
			clear.setEnabled(true);
		}
		else if (cmd.equals("AC")  && !displayText.equals("")) {
			display.setText("0");
			Reset();
			clear.setEnabled(false);
		}
		
		try {
			/** Sometimes text cannot be converted to number.  */
			double displayValue = Double.parseDouble(displayText);

			if (checkNumber(displayValue)) {
				
				switch(cmd) {
					case "0":
						if (!displayText.equals("0")) {
							display.setText(displayText + 0);
						}
						else if (displayText.equals("0")) {
							display.setText("0");
						}
						break;
					case "1":
						displayChange(1);
						break;
					case "2":
						displayChange(2);
						break;
					case "3":
						displayChange(3);
						break;
					case "4":
						displayChange(4);
						break;
					case "5":
						displayChange(5);
						break;
					case "6":
						displayChange(6);
						break;
					case "7":
						displayChange(7);
						break;
					case "8":
						displayChange(8);
						break;
					case "9":
						displayChange(9);
						break;
					case ".":
						if (!displayText.contains(".")) {
							display.setText(displayText + ".");
						}
						break;
					case "+/-":
						if (displayText.equals("0")) {
							// Do nothing.  
						}
						// Positive to negative.  
						else if (!displayText.contains("-")) {
							display.setText("-" + displayText);
						}
						else { // Negative to positive.  
							displayText = displayText.replace("-", "");
							display.setText(displayText);
						}
						break;
					case "\u03C0":
						display.setText("3.14159265");
						break;
					default:
						// Do nothing.  
						break;
				}
				
			}
			
			if (isWorking(displayText)) {
				switch(cmd) {
					case "+":
						operator = "+";
						Operator();
						break;
					case "-":
						operator = "-";
						Operator();
						break;
					case "*":
						operator = "*";
						Operator();
						break;
					case "/":
						operator = "/";
						Operator();
						break;
					case "\u221A":
						operator = "root";
						Operator();
						break;
					case "a^b":
						operator = "power";
						Operator();
						break;
					case "=":
						if (!operator.equals("")) {
							try {
								num2 = Double.parseDouble(displayText);
								String result; 
								switch(operator) {
									case "+":
										num1 = num1 + num2;
										break;
									case "-":
										num1 = num1 - num2;
										break;
									case "*":
										num1 = num1 * num2;
										break;
									case "/":
										if (num2 == 0) {
											throw new DivideByZeroException();
										}
										num1 = num1 / num2;
										break;
									case "root":
										num1 = Math.pow(num1, 1.0 / num2);
										break;
									case "power":
										num1 = Math.pow(num1, num2);
										break;
									default:
										// Do nothing.  
										break; 
								}
								if (num1 > 999999999 || num1 < -999999999) {
									throw new OutOfRangeException();
								}
								result = Reformat();
								display.setText(result);
								Reset();
								clear.setEnabled(false);
								equal.setEnabled(false);
							}
							catch (DivideByZeroException | OutOfRangeException e) {
								display.setText("ERROR");
							}
						}
						break;
					case "C":
						if (displayValue > -10 && displayValue < 10) {
							display.setText("0");
						}
						else {
							displayText = displayText.substring(0, displayText.length() - 1);
							display.setText(displayText);
						}
					default:
						// Do nothing.  
						break;
				}
			}
			
		}
		catch (Exception e) {
			// Do nothing.  
		}
		
	}
	
	
	public void Reset() {
		num1 = 0;
		num2 = 0;
		operator = "";
		add.setEnabled(true);
		subtract.setEnabled(true);
		multiply.setEnabled(true);
		divide.setEnabled(true);
		root.setEnabled(true);
		power.setEnabled(true);
		equal.setEnabled(true);
	}
	
	
	public boolean checkNumber(double displayValue) {

		String displayText = display.getText();
		char[] dtCharArray = displayText.toCharArray();
		/** It should be 0 at start, so numberCount starts at 1.  */
		int numberCount = 1;
		
		for (int i = 0; i < dtCharArray.length; i++) {
			if (dtCharArray[i] == '0' || dtCharArray[i] == '1' 
					|| dtCharArray[i] == '2' || dtCharArray[i] == '3' 
					|| dtCharArray[i] == '4' || dtCharArray[i] == '5' 
					|| dtCharArray[i] == '6' || dtCharArray[i] == '7' 
					|| dtCharArray[i] == '8' || dtCharArray[i] == '9') {
				numberCount++;
			}
		}
		
		if (displayValue >= -999999999 && displayValue <= 999999999
				&& displayText.length() <= 12 && numberCount <= 9 
				&& !displayText.equals("ERROR")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public void displayChange(int number) {

		String displayText = display.getText();
		
		if (displayText.equals("0")) {
			display.setText("" + number);
		} 
		else {
			display.setText(displayText + number);
		}
		
	}
	
	
	/** Checks if calculator is working.  */
	public boolean isWorking(String displayText) {
		if (!displayText.equals("ERROR") || !displayText.equals("")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void Operator() {
		String displayText = display.getText(); 
		num1 = Double.parseDouble(displayText);	
		display.setText("0");
		add.setEnabled(false);
		subtract.setEnabled(false);
		multiply.setEnabled(false);
		divide.setEnabled(false);
		root.setEnabled(false);
		power.setEnabled(false);
		clear.setEnabled(true);
		equal.setEnabled(true);
	}
	
	
	public String Reformat() {
		
		// Get the digits of the rounded (round down to int) num1.  
		int num1Int = (int) Math.floor(Math.abs(num1));
		String num1String = num1Int + "";
		int digits = num1String.length();
		
		String num9d;
		
		switch(digits) {
			case 1:
				DecimalFormat df1 = new DecimalFormat("0.00000000");
				num9d = df1.format(num1);
				break;
			case 2:
				DecimalFormat df2 = new DecimalFormat("0.0000000");
				num9d = df2.format(num1);
				break;
			case 3:
				DecimalFormat df3 = new DecimalFormat("0.000000");
				num9d = df3.format(num1);
				break;
			case 4:
				DecimalFormat df4 = new DecimalFormat("0.00000");
				num9d = df4.format(num1);
				break;
			case 5:
				DecimalFormat df5 = new DecimalFormat("0.0000");
				num9d = df5.format(num1);
				break;
			case 6:
				DecimalFormat df6 = new DecimalFormat("0.000");
				num9d = df6.format(num1);
				break;
			case 7:
				DecimalFormat df7 = new DecimalFormat("0.00");
				num9d = df7.format(num1);
				break;
			case 8:
				DecimalFormat df8 = new DecimalFormat("0.0");
				num9d = df8.format(num1);
				break;
			default: // case 9.  
				DecimalFormat df9 = new DecimalFormat("0");
				num9d = df9.format(num1);
				break;
		}
		
		String[] num9dSplit = num9d.split("\\.", 2);
		String num9dWhole = num9dSplit[0];
		String num9dFractions = num9dSplit[1];
		for (int i = (num9dFractions.length() - 1); i >= 0; i--) {
			if (num9dFractions.charAt(i) == '0') {
				num9dFractions = num9dFractions.substring(0, i);
			}
			else {
				break;
			}
		}
		
		String numFinal = num9dWhole + "." + num9dFractions;
		if (numFinal.charAt(numFinal.length() - 1) == '.') {
			numFinal = numFinal.substring(0, numFinal.length() - 1);
		}
		
		return numFinal;
	}
	
	
	public static void main(String args[]) {
		SimpleCalculator frame = new SimpleCalculator();
		frame.setVisible(true);
	}
	
	
}