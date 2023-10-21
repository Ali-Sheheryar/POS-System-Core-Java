package KSA.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import KSA.controller.HomeController;
import KSA.dto.InvoiceDTO;
import KSA.dto.StockDTO;

public class HomeView extends JFrame implements Printable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4246493674316980516L;
	private JTextField txtInvNo;
	private JTextField txtDate;
	private JTextField txtCustName;
	private JTextField txtMS;
	private JTextField txtDescription;
	private JTextField txtQuantity;
	private JTextField txtUnitPrice;
	private JTextField txtTotalValue;
	private JTextField txtDiscount;
	private JTextField txtVAT;
	private JTextField txtTotalInv;
	private JTextField txtNetInv;
	private JComboBox<String> cmbPartName = new JComboBox<>();
	private JRadioButton rdBtnPaid = new JRadioButton("Paid");
	private JRadioButton rdBtnUnpaid = new JRadioButton("UnPaid");

	private int invNo;
	private String dateString;
	private String custName;
	private String MS;
	private String partName;
	private double quantity;
	private double unitPrice;
	private double totalValue;
	private double discount;
	private double netInvoice;
	private double taxVAT;
	private double totalInv;
	private double totalValueF;
	private double realUnitPrice;
	private double realStock;
	private String paid;
	private String setPaid;
	private String rdPaidUnpaid;
	private double realStockF;
	
	List<InvoiceDTO> invoiceList = new ArrayList<>();

	private static Date currentDate = new Date();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	private HomeController homeController = new HomeController();

	public HomeView() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java-WorkSpace\\KSA\\src\\icon\\iconWindow.jpg"));
		setTitle("YOUR SHOP");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 204, 102)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1288, 712);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBackground(new Color(0, 204, 102));
		panel_1.setBounds(0, 0, 236, 712);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMain = new JLabel("YOUR SHOP");
		lblMain.setBorder(null);
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setForeground(Color.WHITE);
		lblMain.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblMain.setBounds(10, 0, 216, 51);
		panel_1.add(lblMain);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView.this.setVisible(false);
				DashboardView dashboardView = new DashboardView();
				dashboardView.setVisible(true);
			}
		});
		btnDashboard.setForeground(new Color(0, 204, 102));
		btnDashboard.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(10, 166, 216, 42);
		panel_1.add(btnDashboard);

		JButton btnNewItem = new JButton("ADD NEW ITEM");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView.this.setVisible(false);
				NewItemView newItem = new NewItemView();
				newItem.setVisible(true);
			}
		});
		btnNewItem.setForeground(new Color(0, 204, 102));
		btnNewItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewItem.setBackground(Color.WHITE);
		btnNewItem.setBounds(10, 213, 216, 42);
		panel_1.add(btnNewItem);

		JButton btnStock = new JButton("STOCK");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView.this.setVisible(false);
				StockView stockView = new StockView();
				stockView.setVisible(true);
			}
		});
		btnStock.setForeground(new Color(0, 204, 102));
		btnStock.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnStock.setBackground(Color.WHITE);
		btnStock.setBounds(10, 260, 216, 42);
		panel_1.add(btnStock);

		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView.this.setVisible(false);
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}
		});
		btnlogout.setForeground(new Color(0, 204, 102));
		btnlogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnlogout.setBackground(Color.WHITE);
		btnlogout.setBounds(10, 307, 216, 42);
		panel_1.add(btnlogout);

		JLabel lblNewLabel = new JLabel("_____________________________________");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 50, 268, 14);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(0, 204, 102));
		panel_2.setBounds(235, 0, 1131, 64);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBounds(42, 11, 141, 44);
		panel_2.add(lblHome);

		JLabel lblCreateAnInvoice = new JLabel("CREATE YOUR INVOICE HERE");
		lblCreateAnInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAnInvoice.setForeground(new Color(0, 204, 102));
		lblCreateAnInvoice.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblCreateAnInvoice.setBackground(Color.WHITE);
		lblCreateAnInvoice.setBounds(276, 85, 438, 64);
		panel.add(lblCreateAnInvoice);

		JLabel lblCustNo = new JLabel("INVOICE NO :");
		lblCustNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustNo.setForeground(new Color(0, 204, 102));
		lblCustNo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblCustNo.setBackground(Color.WHITE);
		lblCustNo.setBounds(298, 196, 87, 27);
		panel.add(lblCustNo);

		txtInvNo = new JTextField();
		txtInvNo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtInvNo.setBounds(387, 196, 221, 28);
		txtInvNo.setEditable(false);
		panel.add(txtInvNo);
		txtInvNo.setColumns(10);

		JLabel lblDate = new JLabel("DATE : ");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(new Color(0, 204, 102));
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(796, 196, 87, 27);
		panel.add(lblDate);

		txtDate = new JTextField();
		txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtDate.setColumns(10);
		txtDate.setBounds(883, 196, 293, 28);
		txtDate.setText(dateString);
		txtDate.setEditable(false);
		panel.add(txtDate);

		JLabel lblCustName = new JLabel("CUST NAME :");
		lblCustName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustName.setForeground(new Color(0, 204, 102));
		lblCustName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblCustName.setBackground(Color.WHITE);
		lblCustName.setBounds(298, 234, 87, 27);
		panel.add(lblCustName);

		txtCustName = new JTextField();
		txtCustName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtCustName.setColumns(10);
		txtCustName.setBounds(387, 234, 221, 28);
		txtCustName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(txtCustName);

		JLabel lblMS = new JLabel("M/S : ");
		lblMS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMS.setForeground(new Color(0, 204, 102));
		lblMS.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMS.setBackground(Color.WHITE);
		lblMS.setBounds(796, 234, 87, 27);
		panel.add(lblMS);

		txtMS = new JTextField();
		txtMS.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtMS.setColumns(10);
		txtMS.setBounds(883, 234, 293, 28);
		txtMS.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(txtMS);

		JLabel lblPartName = new JLabel("PART NAME :");
		lblPartName.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartName.setForeground(new Color(0, 204, 102));
		lblPartName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPartName.setBackground(Color.WHITE);
		lblPartName.setBounds(300, 361, 87, 27);
		panel.add(lblPartName);

		JLabel lblDescription = new JLabel("DESCRIPTION : ");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setForeground(new Color(0, 204, 102));
		lblDescription.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setBounds(786, 361, 99, 27);
		panel.add(lblDescription);

		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtDescription.setColumns(10);
		txtDescription.setBounds(885, 361, 293, 28);
		panel.add(txtDescription);

		JLabel lblQuantity = new JLabel("QUANTITY   :");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setForeground(new Color(0, 204, 102));
		lblQuantity.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblQuantity.setBackground(Color.WHITE);
		lblQuantity.setBounds(300, 397, 87, 27);
		panel.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtQuantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				validateProductQuantity();
				showTotalValue();
			}
		});
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(389, 397, 111, 28);
		panel.add(txtQuantity);

		txtTotalValue = new JTextField();
		txtTotalValue.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTotalValue.setColumns(10);
		txtTotalValue.setEditable(false);
		txtTotalValue.setBounds(1067, 396, 111, 28);
		panel.add(txtTotalValue);

		JLabel lblDiscount = new JLabel("DISCOUNT   :");
		lblDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiscount.setForeground(new Color(0, 204, 102));
		lblDiscount.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDiscount.setBackground(Color.WHITE);
		lblDiscount.setBounds(299, 432, 87, 27);
		panel.add(lblDiscount);

		txtDiscount = new JTextField();
		txtDiscount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtDiscount.setText("0");
		txtDiscount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				showTotalValue();
			}
		});
		txtDiscount.setColumns(10);
		txtDiscount.setBounds(388, 432, 111, 28);
		panel.add(txtDiscount);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new LineBorder(new Color(0, 204, 102), 1, true));
		panel_5.setBounds(276, 169, 1004, 121);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JButton btnTblRefresh_1 = new JButton("");
		btnTblRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTxtTop();
			}
		});
		btnTblRefresh_1.setIcon(new ImageIcon("E:\\Java-WorkSpace\\KSA\\src\\icon\\arrow.png"));
		btnTblRefresh_1.setForeground(new Color(0, 204, 102));
		btnTblRefresh_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTblRefresh_1.setBorder(null);
		btnTblRefresh_1.setBackground(Color.WHITE);
		btnTblRefresh_1.setBounds(944, 27, 37, 29);
		panel_5.add(btnTblRefresh_1);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new LineBorder(new Color(0, 204, 102), 1, true));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(276, 333, 1004, 191);
		panel.add(panel_5_1);

		txtVAT = new JTextField();
		txtVAT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtVAT.setText("15");
		txtVAT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				showTotalValue();
			}
		});
		txtVAT.setColumns(10);
		txtVAT.setBounds(112, 132, 111, 28);
		panel_5_1.add(txtVAT);

		JLabel lbltaxVAT = new JLabel("V.A.T           : ");
		lbltaxVAT.setHorizontalAlignment(SwingConstants.LEFT);
		lbltaxVAT.setForeground(new Color(0, 204, 102));
		lbltaxVAT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbltaxVAT.setBackground(Color.WHITE);
		lbltaxVAT.setBounds(22, 132, 87, 27);
		panel_5_1.add(lbltaxVAT);

		txtTotalInv = new JTextField();
		txtTotalInv.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTotalInv.setColumns(10);
		txtTotalInv.setEditable(false);
		txtTotalInv.setBounds(791, 132, 111, 28);
		panel_5_1.add(txtTotalInv);

		txtNetInv = new JTextField();
		txtNetInv.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtNetInv.setColumns(10);
		txtNetInv.setEditable(false);
		txtNetInv.setBounds(791, 98, 111, 28);
		panel_5_1.add(txtNetInv);

		JLabel lblUnitPrice = new JLabel("UNIT PRICE :");
		lblUnitPrice.setBounds(298, 63, 87, 27);
		panel_5_1.add(lblUnitPrice);
		lblUnitPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnitPrice.setForeground(new Color(0, 204, 102));
		lblUnitPrice.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblUnitPrice.setBackground(Color.WHITE);

		txtUnitPrice = new JTextField();
		txtUnitPrice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtUnitPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				validateProductPrice();
				showTotalValue();
			}
		});
		txtUnitPrice.setBounds(381, 63, 111, 28);
		panel_5_1.add(txtUnitPrice);
		txtUnitPrice.setColumns(10);

		JButton btnTblRefresh_1_1 = new JButton("");
		btnTblRefresh_1_1.setBounds(943, 28, 37, 29);
		panel_5_1.add(btnTblRefresh_1_1);
		btnTblRefresh_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTxtBottom();
			}
		});
		btnTblRefresh_1_1.setIcon(new ImageIcon("E:\\Java-WorkSpace\\KSA\\src\\icon\\arrow.png"));
		btnTblRefresh_1_1.setForeground(new Color(0, 204, 102));
		btnTblRefresh_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTblRefresh_1_1.setBorder(null);
		btnTblRefresh_1_1.setBackground(Color.WHITE);

		JLabel lblTotalValue = new JLabel("TOTAL VALUE :");
		lblTotalValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalValue.setForeground(new Color(0, 204, 102));
		lblTotalValue.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTotalValue.setBackground(Color.WHITE);
		lblTotalValue.setBounds(693, 63, 99, 27);
		panel_5_1.add(lblTotalValue);

		JLabel lblNetInvoice = new JLabel("NET INVOICE :");
		lblNetInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetInvoice.setForeground(new Color(0, 204, 102));
		lblNetInvoice.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNetInvoice.setBackground(Color.WHITE);
		lblNetInvoice.setBounds(699, 98, 98, 27);
		panel_5_1.add(lblNetInvoice);

		JLabel lblTotalInvoice = new JLabel("TOTAL INVOICE :");
		lblTotalInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalInvoice.setForeground(new Color(0, 204, 102));
		lblTotalInvoice.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTotalInvoice.setBackground(Color.WHITE);
		lblTotalInvoice.setBounds(682, 132, 109, 27);
		panel_5_1.add(lblTotalInvoice);

		cmbPartName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUnitPrice.setText("");
				txtTotalValue.setText("");
				txtNetInv.setText("");
				txtTotalInv.setText("");
				showUnitPrice();
			}
		});
		cmbPartName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbPartName.setBackground(new Color(255, 255, 255));
		cmbPartName.setBounds(112, 28, 223, 28);
		panel_5_1.add(cmbPartName);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(0, 204, 102));
		panel_2_1.setBounds(235, 648, 1131, 64);
		panel.add(panel_2_1);

		int InvNo = homeController.autoIncrInvoiceNo();
		setInvNo(InvNo);

		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduct();
			}
		});
		btnCheckout.setForeground(new Color(0, 204, 102));
		btnCheckout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCheckout.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnCheckout.setBackground(Color.WHITE);
		btnCheckout.setBounds(1035, 593, 141, 29);
		panel.add(btnCheckout);

		dateString = dateFormat.format(currentDate);
		rdBtnPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdBtnUnpaid.isSelected()) {
					rdBtnUnpaid.setSelected(false);
				}
			}
		});
		rdBtnPaid.setName("paid");

		rdBtnPaid.setBackground(new Color(255, 255, 255));
		rdBtnPaid.setForeground(new Color(0, 204, 102));
		rdBtnPaid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdBtnPaid.setBounds(883, 557, 109, 23);
		panel.add(rdBtnPaid);
		rdBtnUnpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdBtnPaid.isSelected()) {
					rdBtnPaid.setSelected(false);
				}
			}
		});
		rdBtnUnpaid.setName("unpaid");

		rdBtnUnpaid.setBackground(new Color(255, 255, 255));
		rdBtnUnpaid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdBtnUnpaid.setForeground(new Color(0, 204, 102));
		rdBtnUnpaid.setBounds(1035, 557, 127, 23);
		panel.add(rdBtnUnpaid);
		populateCmbProductBox();

		addCharFilter(txtCustName);
		addCharFilter(txtMS);
		addCharFilter(txtDescription);

		addDoubleFilter(txtQuantity);
		addDoubleFilter(txtUnitPrice);
		addDoubleFilter(txtDiscount);
		addDoubleFilter(txtVAT);
		
		JButton btnAddToCart = new JButton("ADD");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToCart();
			}
		});
		btnAddToCart.setForeground(new Color(0, 204, 102));
		btnAddToCart.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAddToCart.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnAddToCart.setBackground(Color.WHITE);
		btnAddToCart.setBounds(883, 593, 141, 29);
		panel.add(btnAddToCart);

	}

	private void addCharFilter(JTextField textField) {
		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume(); // Consume the event, preventing the input of non-character characters
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

	public void populateCmbProductBox() {
		List<String> productsName = getProductsName();
		for (String productName : productsName) {
			cmbPartName.addItem(productName);
		}
	}

	public List<String> getProductsName() {
		return homeController.getProductsName();
	}

	public void showUnitPrice() {
		StockDTO stockDTO = new StockDTO();
		partName = (String) cmbPartName.getSelectedItem();
		stockDTO.setPartName(partName);
		stockDTO.setUnitPrice(getTxtUnitPrice());
		homeController.showUnitPrice(stockDTO);
		txtUnitPrice.setText(String.valueOf(stockDTO.getUnitPrice()));
	}

	public void validateProductQuantity() {
		double availQuantity = 0.0;
		double Quantity = getTxtQuantity();
		StockDTO stockDTO = new StockDTO();
		partName = (String) cmbPartName.getSelectedItem();
		stockDTO.setPartName(partName);
		availQuantity = homeController.validateProductQuantity(stockDTO);
		if (Quantity == 0) {
			JOptionPane.showMessageDialog(null, "لا يمكن أن تكون الكمية صفرًا!");
			txtQuantity.setText("");
		} else if (Quantity > availQuantity) {
			JOptionPane.showMessageDialog(null, " المخزون المتاح هو: " + availQuantity);
			txtQuantity.setText("");
			return;
		}
	}

	public void validateProductPrice() {
		double availPrice = 0.0;
		double price = getTxtUnitPrice(); // Update variable name to price
		StockDTO stockDTO = new StockDTO();
		partName = (String) cmbPartName.getSelectedItem();
		stockDTO.setPartName(partName);
		availPrice = homeController.validateProductPrice(stockDTO); // Call validateProductPrice instead
		if (price == 0) { // Change the condition message
			JOptionPane.showMessageDialog(null, "Price must be greater than Zero");
			txtUnitPrice.setText("");
		} else if (price < availPrice) { // Change the condition message
			int choice = JOptionPane.showConfirmDialog(null, "Do you confirm this action?", "Attention",
					JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.NO_OPTION) {
				txtUnitPrice.setText("");
				return;
			}
		}
	}

	public void showTotalValue() {

		double quantity = Double.parseDouble(txtQuantity.getText());
		double price = Double.parseDouble(txtUnitPrice.getText());
		double totalPrice = quantity * price;
		String totalPriceF = String.format("%.2f", totalPrice);
		txtTotalValue.setText(totalPriceF);

		double discountAmount = Double.parseDouble(txtDiscount.getText());
		double discountPercentage = (totalPrice * discountAmount) / 100;
		discountPercentage = (totalPrice - discountPercentage);
		String discountPercentageF = String.format("%.2f", discountPercentage);
		txtNetInv.setText(discountPercentageF);

		Double realStock2 = 0.0;
		Double realStock3 = 0.0;

		double netInv = Double.parseDouble(txtNetInv.getText());
		double taxVAT = Double.parseDouble(txtVAT.getText());
		realStock = realUnitPrice * quantity;
		realStock2 = (realStock * (taxVAT / 100));
		realStock3 = realStock + realStock2;
		realStockF = realStock3;
		totalValueF = (netInv * taxVAT) / 100;
		double netTotalInvoice = (netInv + totalValueF);
		String netTotalInvoiceF = String.format("%.2f", netTotalInvoice);
		txtTotalInv.setText(netTotalInvoiceF);

	}

	public void insertProduct() {
		rdPaidUnpaid = paid;
		if (custName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Customer name is required");
			return;
		}
		if (rdPaidUnpaid.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Select an option from Paid and Unpaid!");
			return;
		}
		List<InvoiceDTO> invoiceList = addToCart();
		homeController.insertProduct(invoiceList, rdPaidUnpaid);
	}

	public List<InvoiceDTO> addToCart() {
		partName = (String) cmbPartName.getSelectedItem();
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setInvNo(getTxtInvNo());
		invoiceDTO.setCustName(getTxtCustName());
		invoiceDTO.setDateString(getDateString());
		invoiceDTO.setMS(getTxtMS());
		invoiceDTO.setPartName(partName);
		invoiceDTO.setquantity(getTxtQuantity());
		invoiceDTO.setDescription(getTxtDescription());
		invoiceDTO.setUnitPrice(getTxtUnitPrice());
		invoiceDTO.setTotalValue(getTxtTotalValue());
		invoiceDTO.setDiscount(getTxtDiscount());
		invoiceDTO.setNetInvoice(getTxtNetInv());
		invoiceDTO.setTaxVAT(getTxtVAT());
		invoiceDTO.setTotalInv(getTxtTotalInv());
		invoiceDTO.setRealStockF(getRealStockF());
		return homeController.addToCart(invoiceList, invoiceDTO);
	}

	public void printInvoice() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);

		try {
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}

		String Paid = "paid";
		if (paid.equals(Paid)) {
			setPaid = "Paid";
		} else {
			setPaid = "Unpaid";
		}
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		Font titleFont = new Font("Arial", Font.BOLD, 35);
		Font regFont = new Font("Arial", Font.PLAIN, 12);

		Color titleColor = Color.GREEN;

		g2d.setFont(titleFont);
		g2d.setColor(titleColor);
		g2d.drawString("Your Shop Invoice", 110, 45);

		g2d.setColor(Color.BLACK);
		g2d.setFont(regFont);

		int startX = 15;
		int startY = 105;
		int rowHeight = 20;
		float colWidth = (float) 112.5;
		// Draw rows
		for (int i = 0; i < 3; i++) {
			int y = startY + i * rowHeight;
			g2d.drawLine(startX, y, (int) (startX + 4 * colWidth), y);
		}

		// Draw columns
		for (int i = 0; i < 5; i++) {
			int x = (int) (startX + i * colWidth);
			g2d.drawLine(x, startY, x, startY + 2 * rowHeight);
		}

		g2d.drawString("Invoice no", 390, 120);
		g2d.drawString("" + invNo, 390, 140);

		g2d.drawString("Date", 270, 120);
		g2d.drawString("" + dateString, 260, 140);

		g2d.drawString("Customer name", 160, 120);
		g2d.drawString("" + custName, 140, 140);

		g2d.drawString("M/S", 50, 120);
		g2d.drawString("" + MS, 30, 140);

		int startX2 = 15;
		int startY2 = 145;
		int rowHeight2 = 20;
		int colWidth2 = 75;
		// Draw rows
		for (int i = 0; i < 3; i++) {
			int y = startY2 + i * rowHeight2;
			g2d.drawLine(startX2, y, startX2 + 6 * colWidth2, y);
		}

		// Draw columns
		for (int i = 0; i < 7; i++) {
			int x = startX2 + i * colWidth2;
			g2d.drawLine(x, startY2, x, startY2 + 2 * rowHeight2);
		}

		g2d.drawString("" + partName, 400, 180);
		g2d.drawString("Product Name", 410, 160);

		g2d.drawString("" + quantity, 350, 180);
		g2d.drawString("Quantity", 345, 160);

		g2d.drawString("" + unitPrice, 260, 180);
		g2d.drawString("Unit Price", 260, 160);

		g2d.drawString("" + totalValue, 185, 180);
		g2d.drawString("Total Price", 175, 160);

		g2d.drawString("" + discount, 120, 180);
		g2d.drawString("Discount", 120, 160);

		g2d.drawString("" + netInvoice, 25, 180);
		g2d.drawString("Net Price", 25, 160);

		int startX3 = 15;
		int startY3 = 185;
		int rowHeight3 = 20;
		int colWidth3 = 150;
		// Draw rows
		for (int i = 0; i < 3; i++) {
			int y = startY3 + i * rowHeight3;
			g2d.drawLine(startX3, y, startX3 + 3 * colWidth3, y);
		}

		// Draw columns
		for (int i = 0; i < 4; i++) {
			int x = startX3 + i * colWidth3;
			g2d.drawLine(x, startY3, x, startY3 + 2 * rowHeight3);
		}

		g2d.drawString("" + taxVAT, 380, 220);
		g2d.drawString("VAT Tax", 380, 200);

		g2d.drawString("" + totalInv, 220, 220);
		g2d.drawString("Total Net Price", 220, 200);

		g2d.drawString("Paid", 80, 200);
		g2d.setColor(Color.BLUE);
		g2d.drawString(setPaid, 80, 220);

		g2d.drawString("Custom field...", 400, 300);
		g2d.drawString("Custom field...", 400, 320);

		g2d.setColor(Color.BLACK);
		g2d.drawString("Salesman Signature", 380, 280);
		g2d.drawString("_______________ ", 280, 300);
		g2d.drawString("_______________ ", 280, 320);

		return PAGE_EXISTS;
	}

	public void resetTxtTop() {
		txtCustName.setText("");
		txtMS.setText("");
	}

	public void resetTxtBottom() {
		txtDescription.setText("");
		txtQuantity.setText("");
		txtTotalValue.setText("");
		txtNetInv.setText("");
		txtTotalInv.setText("");
	}

	public void getRdValue() {
		if (rdBtnPaid.isSelected()) {
			paid = rdBtnPaid.getName();
		} else if (rdBtnUnpaid.isSelected()) {
			paid = rdBtnUnpaid.getName();
		} else {
			JOptionPane.showMessageDialog(null, "Select an option from Paid and Unpaid!");
			return;
		}
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public double getRealStockF() {
		return realStockF;
	}

	public int getTxtInvNo() {
		return Integer.parseInt(txtInvNo.getText());
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public String getTxtCustName() {
		return txtCustName.getText();
	}

	public String getTxtMS() {
		return txtMS.getText();
	}

	public String getTxtDescription() {
		return txtDescription.getText();
	}

	public double getTxtQuantity() {
		return Double.parseDouble(txtQuantity.getText());
	}

	public double getTxtUnitPrice() {
		return Double.parseDouble(txtUnitPrice.getText());
	}

	public double getTxtTotalValue() {
		return Double.parseDouble(txtTotalValue.getText());
	}

	public double getTxtDiscount() {
		return Double.parseDouble(txtDiscount.getText());
	}

	public double getTxtVAT() {
		return Double.parseDouble(txtVAT.getText());
	}

	public double getTxtTotalInv() {
		return Double.parseDouble(txtTotalInv.getText());
	}

	public double getTxtNetInv() {
		return Double.parseDouble(txtNetInv.getText());
	}

	public double getRealStock() {
		return realStock;
	}
}
