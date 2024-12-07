package software.ulpgc.moneyCalculator.view.swing;



import software.ulpgc.moneyCalculator.model.Money;
import software.ulpgc.moneyCalculator.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private JLabel moneyLabel;

    public SwingMoneyDisplay() {;
        this.setLayout(new FlowLayout());
        this.add(createMoneyLabel());
    }

    private Component createMoneyLabel() {
        JLabel label = new JLabel();
        moneyLabel = label;
        return label;
    }

    private JLabel moneyLabel(){
        return moneyLabel;
    }

    @Override
    public void show(Money money) {
        this.moneyLabel().setText(money.toString());
    }
}
