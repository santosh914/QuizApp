package com.santosh.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class QuizApp extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnMark for review;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	QuizApp(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnMark for review = new JButton("Mark for review");
		btnNext.addActionListener(this);
		btnMark for review.addActionListener(this);
		add(btnNext);
		add(btnMark for review);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnMark for review.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnMark for review.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Mark for review")) {
			JButton bk = new JButton("Mark for review" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnMark for review.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Mark for review" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  who is the father of java?");
			radioButton[0].setText("James Gosling");
			radioButton[1].setText("Tim BernesLee");
			radioButton[2].setText("Dennis Ritchie");
			radioButton[3].setText("Guido Van Rossum");
		}
		if (current == 1) {
			label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 2) {
			label.setText("Que3: The \u0021 reffered to as a.");
			radioButton[0].setText("Unicode escape sequence");
			radioButton[1].setText("octal escape");
			radioButton[2].setText("Hexadecimal");
			radioButton[3].setText("Line Feed");
		}
		if (current == 3) {
			label.setText("Que4:____is used to find and fix bugs in the java program.");
			radioButton[0].setText("JVM");
			radioButton[1].setText("JRE");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JDB");
		}
		if (current == 4) {
			label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
			radioButton[0].setText(" Nashorn");
			radioButton[1].setText("V8");
			radioButton[2].setText("Inscript");
			radioButton[3].setText("Narcissus");
		}
		if (current == 5) {
			label.setText("Que6: Which package contains the Random class?");
			radioButton[0].setText("java.util package");
			radioButton[1].setText("java.lang package");
			radioButton[2].setText("java.awt package");
			radioButton[3].setText("java.io package");
		}
		if (current == 6) {
			label.setText("Que7:  Which of the following is a reserved key in java?");
			radioButton[0].setText("object");
			radioButton[1].setText("strictfp");
			radioButton[2].setText("main");
			radioButton[3].setText("system");
		}
		if (current == 7) {
			label.setText("Que8:  in java,jar stands for_____.");
			radioButton[0].setText("Java Archieve Runner");
			radioButton[1].setText("java ARchive");
			radioButton[2].setText("java application runner");
			radioButton[3].setText("none of the above");
		}
		if (current == 8) {
			label.setText("Que9: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is a mutable class in java?");
			radioButton[0].setText("java.lang.String");
			radioButton[1].setText("java.lang.Byte");
			radioButton[2].setText("java.lang.Short");
			radioButton[3].setText("java.lang.StringBuilder");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new QuizApp("Quiz App");
	}

}
