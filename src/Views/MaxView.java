import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class MaxView implements View {

	//Instance variables
	double max;
	JTextField jtfMax;
	String name;

	public MaxView() {
		max = 0;
		jtfMax = new JTextField(5);
		jtfMax.setEditable(false);
		name = "Max";
	}

	@Override
	public void update(ArrayList<Double> numbers) {
		max = MinMaxCalculation.findMax(MinMaxCalculation.getArrayDouble(numbers));

		//Set text
		jtfMax.setText("" + max);

	}

	@Override
	public void reset() {
		jtfMax.setText("");
	}

	@Override
	public JTextComponent show() {
		return jtfMax;
	}

	@Override
	public String getName() {
		return name;
	}

	public double getMax() {
		return max;
	}

}
