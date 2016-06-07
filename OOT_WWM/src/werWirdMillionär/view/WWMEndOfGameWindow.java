package werWirdMillionär.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import werWirdMillionär.model.WWMModel;

public class WWMEndOfGameWindow extends JPanel {
	private JTextField textField;
	private JLabel lblEuro;
	private JLabel lblTime;

	/**
	 * Create the panel.
	 */
	public WWMEndOfGameWindow(WWMModel model) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblHerzlichenGlckwunsch = new JLabel("Herzlichen Glückwunsch!");
		GridBagConstraints gbc_lblHerzlichenGlckwunsch = new GridBagConstraints();
		gbc_lblHerzlichenGlckwunsch.weighty = 0.3;
		gbc_lblHerzlichenGlckwunsch.gridwidth = 0;
		gbc_lblHerzlichenGlckwunsch.insets = new Insets(0, 0, 5, 0);
		gbc_lblHerzlichenGlckwunsch.gridx = 0;
		gbc_lblHerzlichenGlckwunsch.gridy = 0;
		add(lblHerzlichenGlckwunsch, gbc_lblHerzlichenGlckwunsch);
		lblEuro = new JLabel("Sie haben " + model.getPrice() + "€ gewonnen!");
		GridBagConstraints gbc_lblEuro = new GridBagConstraints();
		gbc_lblEuro.weighty = 0.3;
		gbc_lblEuro.gridwidth = 0;
		gbc_lblEuro.insets = new Insets(0, 0, 5, 0);
		gbc_lblEuro.gridx = 0;
		gbc_lblEuro.gridy = 1;
		add(lblEuro, gbc_lblEuro);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 0.2;
		gbc_lblName.weightx = 0.2;
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.highScoreAddEntrie(textField.getText(), (int) model.getGameTime()); 
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weighty = 0.3;
		gbc_textField.weightx = 0.6;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblTime = new JLabel(model.getGameTime() + "s");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.gridwidth = 0;
		gbc_lblTime.weighty = 0.3;
		gbc_lblTime.weightx = 0.2;
		gbc_lblTime.gridx = 2;
		gbc_lblTime.gridy = 2;
		add(lblTime, gbc_lblTime);

	}

}
