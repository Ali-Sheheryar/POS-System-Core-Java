package KSA.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import KSA.controller.NewItemController;
import KSA.dto.StockDTO;

public class NewItemView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8732911947677949420L;
	private JTextField txtPartNo;
	private JTextField txtPartName;
	private JTextField txtPartQuantity;
	private JTextField txtUnitPrice;
	private JTextField txtTotalPrice;
	private JTextField txtVAT;
	static Date currentDate = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private String dateString;
	private JButton btnInsert;
	private NewItemController itemController = new NewItemController();

	public NewItemView() {

		setTitle("Item Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1378, 735);
		setLocationRelativeTo(null);

		setTitle("YOUR SHOP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java-WorkSpace\\KSA\\src\\icon\\iconWindow.jpg"));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1378, 712);
		getContentPane().add(panel);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(0, 204, 102));
		panel_2.setBounds(235, 0, 1135, 64);
		panel.add(panel_2);

		JLabel lblNewItem = new JLabel("ADD NEW STOCK ITEMS");
		lblNewItem.setForeground(Color.WHITE);
		lblNewItem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewItem.setBounds(50, 11, 280, 44);
		panel_2.add(lblNewItem);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBackground(new Color(0, 204, 102));
		panel_1.setBounds(0, 0, 236, 749);
		panel.add(panel_1);

		JLabel lblMain = new JLabel("YOUR SHOP");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setForeground(Color.WHITE);
		lblMain.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblMain.setBorder(null);
		lblMain.setBounds(10, 0, 216, 51);
		panel_1.add(lblMain);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewItemView.this.setVisible(false);
				DashboardView lf = new DashboardView();
				lf.setVisible(true);
			}
		});
		btnDashboard.setForeground(new Color(0, 204, 102));
		btnDashboard.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(10, 224, 216, 42);
		panel_1.add(btnDashboard);

		JButton btnCollection = new JButton("STOCK");
		btnCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewItemView.this.setVisible(false);
				StockView lf = new StockView();
				lf.setVisible(true);
			}
		});
		btnCollection.setForeground(new Color(0, 204, 102));
		btnCollection.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCollection.setBackground(Color.WHITE);
		btnCollection.setBounds(10, 271, 216, 42);
		panel_1.add(btnCollection);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewItemView.this.setVisible(false);
				LoginView lf = new LoginView();
				lf.setVisible(true);
			}
		});
		btnLogout.setForeground(new Color(0, 204, 102));
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(10, 318, 216, 42);
		panel_1.add(btnLogout);

		JLabel lblNewLabel = new JLabel("_____________________________________");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 50, 268, 14);
		panel_1.add(lblNewLabel);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewItemView.this.setVisible(false);
				HomeView lf = new HomeView();
				lf.setVisible(true);
			}
		});
		btnHome.setForeground(new Color(0, 204, 102));
		btnHome.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(10, 177, 216, 42);
		panel_1.add(btnHome);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(0, 204, 102));
		panel_2_1.setBounds(235, 649, 1135, 64);
		panel.add(panel_2_1);

		JLabel lblAddNewItem = new JLabel("ADD NEW STOCK HERE");
		lblAddNewItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddNewItem.setForeground(new Color(0, 204, 102));
		lblAddNewItem.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAddNewItem.setBackground(Color.WHITE);
		lblAddNewItem.setBounds(287, 92, 339, 64);
		panel.add(lblAddNewItem);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 204, 102), 1, true));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(287, 178, 1018, 242);
		panel.add(panel_5);

		JLabel lblPartName = new JLabel("PART NAME : ");
		lblPartName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPartName.setForeground(new Color(0, 204, 102));
		lblPartName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPartName.setBackground(Color.WHITE);
		lblPartName.setBounds(558, 44, 108, 27);
		panel_5.add(lblPartName);

		txtPartName = new JTextField();
		txtPartName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtPartName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean b = validateProduct();
				if (b == true) {
					txtPartName.setText("");
				}
			}
		});
		txtPartName.setColumns(10);
		txtPartName.setBounds(668, 44, 243, 28);
		txtPartName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel_5.add(txtPartName);
		txtPartName.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume(); // Consume the event, preventing the input of non-character characters
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		JLabel lblPartNo = new JLabel("PART       NO  : ");
		lblPartNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartNo.setForeground(new Color(0, 204, 102));
		lblPartNo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPartNo.setBackground(Color.WHITE);
		lblPartNo.setBounds(38, 45, 99, 27);
		panel_5.add(lblPartNo);

		txtPartNo = new JTextField();
		txtPartNo.setColumns(10);
		txtPartNo.setEditable(false);
		txtPartNo.setBounds(135, 45, 243, 28);
		panel_5.add(txtPartNo);

		JLabel lblQuantity = new JLabel("QUANTITY      : ");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setForeground(new Color(0, 204, 102));
		lblQuantity.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblQuantity.setBackground(Color.WHITE);
		lblQuantity.setBounds(38, 108, 99, 27);
		panel_5.add(lblQuantity);

		txtPartQuantity = new JTextField();
		txtPartQuantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotal());
			}
		});
		txtPartQuantity.setColumns(10);
		txtPartQuantity.setBounds(135, 108, 243, 28);
		panel_5.add(txtPartQuantity);

		btnInsert = new JButton("ADD");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduct();
			}
		});
		btnInsert.setForeground(new Color(0, 204, 102));
		btnInsert.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnInsert.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setBounds(789, 170, 123, 29);
		panel_5.add(btnInsert);

		JButton btnTblRefresh = new JButton("");
		btnTblRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTxtFields();
			}
		});
		btnTblRefresh.setIcon(new ImageIcon("E:\\Java-WorkSpace\\KSA\\src\\icon\\arrow.png"));
		btnTblRefresh.setForeground(new Color(0, 204, 102));
		btnTblRefresh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTblRefresh.setBorder(null);
		btnTblRefresh.setBackground(Color.WHITE);
		btnTblRefresh.setBounds(923, 170, 37, 29);
		panel_5.add(btnTblRefresh);

		JLabel lblPrice = new JLabel("PRICE : ");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setForeground(new Color(0, 204, 102));
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setBounds(579, 108, 87, 27);
		panel_5.add(lblPrice);

		txtUnitPrice = new JTextField();
		txtUnitPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotal());
			}
		});
		txtUnitPrice.setColumns(10);
		txtUnitPrice.setBounds(668, 108, 243, 28);
		panel_5.add(txtUnitPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setBounds(135, 170, 243, 28);
		panel_5.add(txtTotalPrice);

		JLabel lblTotalPrice = new JLabel("TOTAL PRICE  : ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(new Color(0, 204, 102));
		lblTotalPrice.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTotalPrice.setBackground(Color.WHITE);
		lblTotalPrice.setBounds(38, 170, 99, 27);
		panel_5.add(lblTotalPrice);

		txtVAT = new JTextField();
		txtVAT.setColumns(10);
		txtVAT.setBounds(668, 170, 116, 28);
		panel_5.add(txtVAT);
		txtVAT.setText("15");
		txtVAT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotal());
			}
		});
		int InvNo = autoIncrProductNo();
		String invNo = String.valueOf(InvNo);
		txtPartNo.setText(invNo);

		JLabel lblVatTax = new JLabel("V.A.T Tax : ");
		lblVatTax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVatTax.setForeground(new Color(0, 204, 102));
		lblVatTax.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblVatTax.setBackground(Color.WHITE);
		lblVatTax.setBounds(579, 170, 87, 27);
		panel_5.add(lblVatTax);
		setVisible(true);

		addDoubleFilter(txtPartQuantity);
		addDoubleFilter(txtUnitPrice);
		addDoubleFilter(txtVAT);

	}

	private void addDoubleFilter(JTextField textField) {
		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0' && c <= '9') || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Not used, but required by KeyListener interface
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Not used, but required by KeyListener interface
			}

		});
	}

	protected void resetTxtFields() {
		txtPartName.setText("");
		txtPartQuantity.setText("");
		txtUnitPrice.setText("");
		txtTotalPrice.setText("");
	}

	public String calculateTotal() {
		double partQuantity = getPartQuantity();
		double price = getPrice();
		double taxVAT = getTaxVAT();
		return itemController.calculateTotal(partQuantity, price, taxVAT);
	}

	private void insertProduct() {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setSrNo(getPartNo());
		stockDTO.setPartName(getPartName());
		stockDTO.setQuantity(getPartQuantity());
		stockDTO.setUnitPrice(getPrice());
		stockDTO.setTotalValue(getPrice());
		dateString = dateFormat.format(currentDate);

		itemController.insertProduct(stockDTO, dateString);
		resetTxtFields();
		autoIncrProductNo();

	}

	private int autoIncrProductNo() {
		return itemController.autoIncrProductNo();
	}

	private boolean validateProduct() {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setPartName(getPartName());
		return itemController.validateProduct(stockDTO);
	}

	public int getPartNo() {
		return Integer.parseInt(txtPartNo.getText());
	}

	public String getPartName() {
		return txtPartName.getText();
	}

	public double getPartQuantity() {
		return Double.parseDouble(txtPartQuantity.getText());
	}

	public double getPrice() {
		return Double.parseDouble(txtUnitPrice.getText());
	}

	public double getTotalPrice() {
		return Double.parseDouble(txtTotalPrice.getText());
	}

	public double getTaxVAT() {
		return Double.parseDouble(txtVAT.getText());
	}

	public JTextField getTxtPartQuantity() {
		return txtPartQuantity;
	}

	public void setTxtPartQuantity(String txtPartQuantity) {
		this.txtPartQuantity.setText(txtPartQuantity);
	}

	public JTextField getTxtUnitPrice() {
		return txtUnitPrice;
	}

	public void setTxtUnitPrice(String txtUnitPrice) {
		this.txtUnitPrice.setText(txtUnitPrice);
	}

	public JTextField getTxtVAT() {
		return txtVAT;
	}

	public void setTxtVAT(String txtVAT) {
		this.txtVAT.setText(txtVAT);
	}
	
	
}
