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
	
	String operator;
	double num1;
	double num2;
	
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
		// display2.setFont(font);
		// display2.setEnabled(false);
		// row1.add(display2);
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

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		String displayText = display.getText();

		if (source == onOff && displayText.equals("")) {
			display.setText("0"); // On
		}
		else if (source == onOff && !displayText.equals("")) {
			display.setText(""); // Off
			num1 = 0;
			num2 = 0;
			operator = "";
		}
		else if (source == allClear && !displayText.equals("")) {
			display.setText("0");
			num1 = 0;
			num2 = 0;
			operator = "";
		}
		
		try {
			/** Sometimes text cannot be converted to number.  */
			double displayValue = Double.parseDouble(display.getText());

			if (source == zero && displayValue <= 999999999 && displayValue >= -999999999) {
				if (!displayText.equals("0") && operator.equals("")) {
					display.setText(displayText + 0);
				}
				else if (!operator.equals("")) {
					display.setText("0");
				}
			}
			else if (source == one && checkNumber(displayValue)) {
				displayChange(1);
			}
			else if (source == two && checkNumber(displayValue)) {
				displayChange(2);
			}
			else if (source == three && checkNumber(displayValue)) {
				displayChange(3);
			}
			else if (source == four && checkNumber(displayValue)) {
				displayChange(4);
			}
			else if (source == five && checkNumber(displayValue)) {
				displayChange(5);
			}
			else if (source == six && checkNumber(displayValue)) {
				displayChange(6);
			}
			else if (source == seven && checkNumber(displayValue)) {
				displayChange(7);
			}
			else if (source == eight && checkNumber(displayValue)) {
				displayChange(8);
			}
			else if (source == nine && checkNumber(displayValue)) {
				displayChange(9);
			}
			else if (source == point && checkNumber(displayValue)) {
				if (!displayText.contains(".")) {
					display.setText(displayText + ".");
				}
			}
			else if (source == negPos && checkNumber(displayValue)) {
				if (!displayText.contains("-")) {
					display.setText("-" + displayText);
				}
				else {
					displayText = displayText.replace("-", "");
					display.setText(displayText);
				}
			}
			else if (source == pi && checkNumber(displayValue)) {
				display.setText("3.14159265");
			}
			else if (source == add && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "+";
				Operator();
			}
			else if (source == subtract && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "-";
				Operator();
			}
			else if (source == multiply && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "*";
				Operator();
			}
			else if (source == divide && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "/";
				Operator();
			}
			else if (source == root && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "root";
				Operator();
			}
			else if (source == power && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				operator = "power";
				Operator();
			}
			else if (source == equal && !displayText.equals("ERROR")) {
				try {
					num2 = Double.parseDouble(displayText);
					String result; 
					if (operator.equals("+")) {
						num1 = num1 + num2;
					}
					else if (operator.equals("-")) {
						num1 = num1 - num2;
					}
					else if (operator.equals("*")) {
						num1 = num1 * num2;
					}
					else if (operator.equals("/")) {
						if (num2 == 0) {
							throw new DivideByZeroException();
						}
						num1 = num1 / num2;
					}
					else if (operator.equals("root")) {
						num1 = Math.pow(num1, 1.0 / num2);
					}
					else if (operator.equals("power")) {
						num1 = Math.pow(num1, num2);
					}
					
					if (num1 > 999999999 || num2 < -999999999) {
						throw new OutOfRangeException();
					}
					result = Reformat();
					display.setText(result);
					operator = "";
				}
				catch (DivideByZeroException | OutOfRangeException e) {
					display.setText("ERROR");
				}
			}
			else if (source == clear && (!displayText.equals("ERROR") || !displayText.equals(""))) {
				if (displayValue > -10 || displayValue < 10) {
					display.setText("0");
				}
				else {
					displayText = displayText.substring(0, displayText.length() - 1);
					display.setText(displayText);
				}
			}
		}
		catch (Exception e) {
			// Do nothing.  
		}
		
	}
	
	
	public boolean checkNumber(double displayValue) {

		String displayText = display.getText();
		char[] dtCharArray = displayText.toCharArray();
		/** It should be 0 at start, so numberCount starts at 1.  */
		int numberCount = 1;
		
		for (int i = 0; i < dtCharArray.length; i++) {
			if (dtCharArray[i] == '0' || dtCharArray[i] == '1' || dtCharArray[i] == '2'
					|| dtCharArray[i] == '3' || dtCharArray[i] == '4'
					|| dtCharArray[i] == '5' || dtCharArray[i] == '6'
					|| dtCharArray[i] == '7' || dtCharArray[i] == '8'
					|| dtCharArray[i] == '9') {
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
	
	
	public void Operator() {
		String displayText = display.getText(); 
		num1 = Double.parseDouble(displayText);	
		// display2.setText(operator); 
		display.setText("0");
	}
	
	
	public String Reformat() {
		if (num1 == 0) {
			return "0";
		}
		else if (num1 < 10) {
			DecimalFormat df = new DecimalFormat("0.00000000");
			return df.format(num1);
		}
		else if (num1 < 100) {
			DecimalFormat df = new DecimalFormat("0.0000000");
			return df.format(num1);
		}
		else if (num1 < 1000) {
			DecimalFormat df = new DecimalFormat("0.000000");
			return df.format(num1);
		}
		else if (num1 < 10000) {
			DecimalFormat df = new DecimalFormat("0.00000");
			return df.format(num1);
		}
		else if (num1 < 100000) {
			DecimalFormat df = new DecimalFormat("0.0000");
			return df.format(num1);
		}
		else if (num1 < 1000000) {
			DecimalFormat df = new DecimalFormat("0.000");
			return df.format(num1);
		}
		else if (num1 < 10000000) {
			DecimalFormat df = new DecimalFormat("0.00");
			return df.format(num1);
		}
		else if (num1 < 100000000) {
			DecimalFormat df = new DecimalFormat("0.0");
			return df.format(num1);
		}
		else { // if (num1 < 1000000000)
			DecimalFormat df = new DecimalFormat("0");
			return df.format(num1);
		}
	}
	
	
	public static void main(String args[]) {
		SimpleCalculator frame = new SimpleCalculator();
		frame.setVisible(true);
	}
	
}