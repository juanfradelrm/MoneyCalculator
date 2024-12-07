package software.ulpgc.moneyCalculator;


import software.ulpgc.moneyCalculator.control.Command;
import software.ulpgc.moneyCalculator.view.CurrencyDialog;
import software.ulpgc.moneyCalculator.view.MoneyDialog;
import software.ulpgc.moneyCalculator.view.MoneyDisplay;
import software.ulpgc.moneyCalculator.view.swing.SwingCurrencyDialog;
import software.ulpgc.moneyCalculator.view.swing.SwingMoneyDialog;
import software.ulpgc.moneyCalculator.view.swing.SwingMoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String,Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;


    public SwingMain() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setSize(800,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(createNortPanel(),BorderLayout.NORTH);
        this.add(createMoneyDisplay(),BorderLayout.CENTER);
        this.add(toolbar(),BorderLayout.SOUTH);
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Exchange money").execute();
            }
        });
        return button;
    }

    private Component createNortPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createMoneyDialog());
        panel.add(createCurrencyDialog());
        return panel;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }



    public void put(String name, Command command) {
        commands.put(name, command);
    }

    public MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    public CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    public MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
