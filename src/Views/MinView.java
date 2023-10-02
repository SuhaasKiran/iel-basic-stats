import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class MinView implements View {

	//Instance variables
	double min;
	JTextField jtfMin;
	String name;

	public MinView() {
		min = 0;
		jtfMin = new JTextField(5);
		jtfMin.setEditable(false);
		name = "Min";
	}

	@Override
	public void update(ArrayList<Double> numbers) {
		min = MinMaxCalculation.findMin(MinMaxCalculation.getArrayDouble(numbers));

		//Set text
		jtfMin.setText("" + min);

	}

	@Override
	public void reset() {
		jtfMin.setText("");
	}

	@Override
	public JTextComponent show() {
		return jtfMin;
	}

	@Override
	public String getName() {
		return name;
	}

	public double getMin() {
		return min;
	}

}
