import java.util.*;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MinMaxCalculation{

    // Store all collected numbers
    private static ArrayList<Double> data = new ArrayList<Double>();

    public static void main(String ... args) {
        //Initialize controllers
    AddNumCtrl numCtrl = new AddNumCtrl();
    ResetCtrl resetCtrl = new ResetCtrl();

    //Initialize model
    Numbers numbers = new Numbers();

    //Initialize views
    MinView minView = new MinView();
    MaxView maxView = new MaxView();
    NumbersView numbersView = new NumbersView();
    CountView countView = new CountView();
    AddNumView addNumView = new AddNumView();
    ResetView resetView = new ResetView();

    //Create minmaxView
    ArrayList<View> minmaxViews = new ArrayList<View>();
    minmaxViews.add(countView);
    minmaxViews.add(minView);
    minmaxViews.add(maxView);

    /***** REGISTER MVC BLOCK *****/

    //Register models to controls
    numCtrl.addModel(numbers);
    resetCtrl.addModel(numbers);

    //Register views to models
    for (View view: minmaxViews) {
      numbers.addObserver(view);
    }
    numbers.addObserver(numbersView);
    numbers.addObserver(addNumView);
    numbers.addObserver(resetView);

    //Register controls to views
    addNumView.addController(numCtrl);
    resetView.addController(resetCtrl);

    /***** END OF REGISTER MVC BLOCK *****/

    // Create the main frame of the application, and set size and position
    JFrame jfMain = new JFrame("Minimum Maximum Calculator");
    jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    jfMain.setSize(1000,900);
    jfMain.setLocationRelativeTo(null);

    // Panel that shows min and max value of the numbers
    JPanel jpMinMax = new JPanel(new FlowLayout(FlowLayout.CENTER));

    for (View view: minmaxViews) {
      jpMinMax.add(new JLabel(view.getName() + ":"));
      jpMinMax.add(view.show());
    }

    //Set Min-Max view
    jfMain.getContentPane().add(jpMinMax, BorderLayout.CENTER);

    // TextArea that shows all the numbers
    jfMain.getContentPane().add(numbersView.show(), BorderLayout.SOUTH);

    //Create panel for input
    JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
    jpInput.add(addNumView.show());
    jpInput.add(addNumView.getButton());
    jpInput.add(resetView.getButton());

    //Set input view
    jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);

    // Show the frame
    jfMain.setVisible(true);

    }
    /**
     * Compute the minimum of an array of numbers.
     */
    public static double findMin(double ... numbers) {
        double min = Double.MAX_VALUE;
        for (double num : numbers) {
            if(num < min)
            min = num;
        }
        if(min == Double.MAX_VALUE)
            return 0;
        return min;
    }

    /**
     * Compute the maximum of an array of numbers.
     */
    public static double findMax(double ... numbers) {
        double max = Double.MIN_VALUE;
        for (double num : numbers) {
            if(num > max)
            max = num;
        }
        if(max == Double.MIN_VALUE)
            return 0;
        return max;
    }

    //Helper method
    public static double[] getArrayDouble(ArrayList<Double> doubles) {
        double[] result = new double[doubles.size()];

        //O(n) iteration to convert result
        for (int i = 0 ; i < doubles.size(); i++) {
            result[i] = doubles.get(i);
        }

        return result;
    }
}