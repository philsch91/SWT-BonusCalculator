package at.fhcampuswien.swtbonuscalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.IllegalFormatException;

public class App implements ActionListener {

    private JFrame mainFrame = null;
    private JPanel topPanel = null;
    private JPanel bottomPanel = null;
    private JLabel mainLabel = null;
    private JTextField mainTextField = null;
    private JRadioButton employeeRadioButton = null;
    private JRadioButton secretaryEmployeeRadioButton = null;
    private JRadioButton postOfficeEmployeeRadioButton = null;
    private JLabel outputLabel = null;
    private JButton calcButton = null;

    public static void main( String[] args ) {
        System.out.println( "--- SWT Bonus Payment ---" );

        Employee e1 = new Employee();
        Calendar entryDate1 = Calendar.getInstance();
        entryDate1.set(1970,1,1);

        try {
            e1.setEntryDate(entryDate1);
        } catch (IllegalArgumentException ex){
            System.out.println("illegal argument");
        }

        Employee e2 = new Employee();
        Calendar entryDate2 = Calendar.getInstance();
        entryDate2.set(1920,1,1);

        try {
            e2.setEntryDate(entryDate2);
        } catch (IllegalArgumentException ex){
            System.out.println("illegal argument");
        }

        App app = new App();
    }

    public App(){
        this.init();
    }

    public void init(){
        this.mainFrame = new JFrame("SWT BonusCalculator");
        this.mainFrame.setSize(300, 300);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //==== topPanel ====

        this.mainLabel = new JLabel("Enter the date (dd-mm-yyyy)");
        this.mainLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
        this.mainLabel.setBounds(50,50,100,44);

        this.mainTextField = new JTextField();
        this.mainTextField.setHorizontalAlignment(JTextField.HORIZONTAL);
        this.mainTextField.addActionListener(this);

        this.employeeRadioButton = new JRadioButton("Employee");
        this.employeeRadioButton.addActionListener(this);

        this.secretaryEmployeeRadioButton = new JRadioButton("SecretaryEmployee");
        this.secretaryEmployeeRadioButton.addActionListener(this);

        this.postOfficeEmployeeRadioButton = new JRadioButton("PostOfficeEmployee");
        this.postOfficeEmployeeRadioButton.addActionListener(this);

        ButtonGroup typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(this.employeeRadioButton);
        typeButtonGroup.add(this.secretaryEmployeeRadioButton);
        typeButtonGroup.add(this.postOfficeEmployeeRadioButton);

        this.outputLabel = new JLabel("");
        this.outputLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
        this.outputLabel.setBounds(50,50,100,44);

        /**
         * JPanel with GridBagLayout
        this.topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10 , 10 , 10);
        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridx = 1;

        constraints.gridx = 0;
        constraints.gridy = 1;
        */

        /**
         * JPanel with BorderLayout
        this.topPanel = new JPanel(new BorderLayout());
        this.topPanel.add(this.mainLabel, BorderLayout.PAGE_START, 0);
        this.topPanel.add(this.mainTextField, BorderLayout.LINE_END, 1);
        */

        this.topPanel = new JPanel();   //FlowLayoutManager
        this.topPanel.setLayout(new BoxLayout(this.topPanel, BoxLayout.PAGE_AXIS));

        this.topPanel.add(this.mainLabel, 0);
        this.topPanel.add(this.mainTextField, BoxLayout.LINE_AXIS, 1);
        this.topPanel.add(this.employeeRadioButton, 2);
        this.topPanel.add(this.secretaryEmployeeRadioButton, 3);
        this.topPanel.add(this.postOfficeEmployeeRadioButton, 4);
        this.topPanel.add(this.outputLabel, 5);

        //==== bottomPanel ====

        this.calcButton = new JButton("Calculate");
        this.calcButton.addActionListener(this);

        this.bottomPanel = new JPanel();
        this.bottomPanel.add(this.calcButton, 0);

        //==== mainFrame ====

        this.mainFrame.add(this.topPanel, BorderLayout.PAGE_START);
        this.mainFrame.add(this.bottomPanel, BorderLayout.PAGE_END);

        this.mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e);
        if(e.getSource() == this.calcButton){
            //System.out.println("calcButton");
            //System.out.println(e.getActionCommand());
            this.handleCalcButtonClick();
        }

        if(e.getSource() == this.mainTextField){
            System.out.println("mainTextField");
        }
    }

    public void handleCalcButtonClick(){
        String text = this.mainTextField.getText();
        System.out.println("Text: " + text);

        Calendar entryDate = null;
        try {
            entryDate = this.parseDateString(text);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

        Employee e = null;

        if(this.employeeRadioButton.isSelected()){
            System.out.println("Employee");
            e = new Employee();
        } else if(this.secretaryEmployeeRadioButton.isSelected()){
            System.out.println("SecretaryEmployee");
            e = new SecretaryEmployee();
        } else if(this.postOfficeEmployeeRadioButton.isSelected()){
            System.out.println("PostOfficeEmployee");
            e = new PostOfficeEmployee();
        }

        e.setEntryDate(entryDate);
        Bonus bonus = e.getBonus();

        this.outputLabel.setText("Bonus = " + bonus.value.toString());
        JOptionPane.showMessageDialog(this.mainFrame,"Bonus = " + bonus.value.toString());
    }

    public Calendar parseDateString(String text) throws IllegalArgumentException {
        String[] dateStrArr = text.split("-");

        if(dateStrArr.length < 3){
            throw new IllegalArgumentException("incorrect text format");
        }

        int day = Integer.parseInt(dateStrArr[0]);
        int month = Integer.parseInt(dateStrArr[1]);
        int year = Integer.parseInt(dateStrArr[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        return calendar;
    }
}
