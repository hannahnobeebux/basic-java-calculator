import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    private static JLabel num1;
    private static JTextField num1Text;
    private static JLabel num2;
    private static JTextField num2Text;

    private static JLabel operator;
    private static JTextField operatorText;
    private static JButton button;
    private static JLabel answer;

    public static void main(String[] args) {
        //THE PANEL IS THE LAYOUT
        JPanel panel = new JPanel();
        //CREATING THE FRAME THAT WILL BE THE GUI
        JFrame frame = new JFrame();

        frame.setSize(350, 200);
//PASSING INTEGERS INTO THE DEFAULT SETTING TO MAKE SURE THE PROGRAM CLOSES PROPERLY
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

//CONFIGURING THE PANEL
        panel.setLayout(null);
//CREATING A NEW LABEL FOR THE USER
        num1 = new JLabel("1st: ");
// THIS DETERMINES COORDINATES/STARTING POINT + WIDTH OF LABEL + HEIGHT OF LABEL --> POSITION (column: 10, row: 20)
        num1.setBounds(10, 20, 80, 25);
        panel.add(num1);
//CREATING A TEXT FIELD FOR THE USERNAME
        num1Text = new JTextField(20);
        num1Text .setBounds(100, 20, 165, 25);
        panel.add(num1Text);
//CREATING A LABEL FOR THE PASSWORD
        num2 = new JLabel("2nd: ");
        num2.setBounds(10, 50, 80, 25);
        panel.add(num2);
//CREATING A TEXT FIELD FOR THE PASSWORD
        num2Text = new JTextField();
        num2Text.setBounds(100, 50, 165, 25);
        panel.add(num2Text);

//CREATING A LABEL FOR THE OPERATOR
        operator = new JLabel("Operator");
        operator.setBounds(10, 90, 80, 25);
        panel.add(operator);
//CREATING A TEXT FIELD FOR THE OPERATOR
        operatorText = new JTextField();
        operatorText.setBounds(100, 90, 165, 25);
        panel.add(operatorText);

//ADDING A SUBMIT BUTTON BELOW THE TEXTFIELDS
        button = new JButton("Calculate!");
        button.setBounds(10, 120, 110, 25);
        // ADDING AN ACTION TO THE BUTTON
        button.addActionListener(new Calculator());
        panel.add(button);

//ADDING A SUCCESS LABEL IF THE USERNAME AND PASSWORD IS VALID
        answer = new JLabel("");
        answer.setBounds(120, 120, 300, 25);
        panel.add(answer);


        frame.setVisible(true);

    }

    //THE BUTTON IS BOUND TO THIS METHOD
//THIS IS THE SECOND METHOD INSIDE THE CLASS "GUI"
    @Override
    public void actionPerformed(ActionEvent e) {
        double result;
//        CAPTURING THEM AS STRINGS
        String one = num1Text.getText();
        String two = num2Text.getText();
        String actualOperator = operatorText.getText();

        Integer oneNum = Integer.parseInt(one);
        Integer twoNum = Integer.parseInt(two);

        if (actualOperator == " " || one == null || two == null) {
            answer.setText("Please enter numbers and try again");
        }

        switch (actualOperator) {
            case "+":
                result = oneNum + twoNum;
                answer.setText("The answer is " + Math.floor(result));
                break;
            case "-":
                result = oneNum - twoNum;
                answer.setText("The answer is " + result);
                break;
            case "*":
                result = oneNum * twoNum;
                answer.setText("The answer is " + result);
                break;
            case "/":
                result = oneNum / twoNum;
                answer.setText("The answer is " + result);
                break;

//            default:
//                if (actualOperator == ""){
//                    answer.setText("Please enter numbers and try again");
//                }

        }

    }
}
