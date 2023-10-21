package KSA.view;

import java.awt.Color;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import KSA.controller.StockController;
import KSA.dto.StockDTO;

public class StockView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6146622169376568874L;
	private JTable productTable;
	private JLabel lblQuantity = new JLabel("Quantity");
	private JLabel lblTotalPrice = new JLabel("Total Price");
	private JLabel lblPrice;
	private JLabel lblTaxVAT = new JLabel("V.A.T Tax");;
	private JTextField txtPartQuantity;
	private JTextField txtPrice;
	private JTextField txtTotalPrice;
	private JTextField txtVAT;
	private String dateString;
	static Date currentDate = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private JComboBox<String> cmbMonth = new JComboBox<>();
	private StockController stockController = new StockController();

	@SuppressWarnings("serial")
	public StockView() {

		setTitle("YOUR SHOP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java-WorkSpace\\KSA\\src\\icon\\iconWindow.jpg"));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1367, 710);
		getContentPane().add(panel);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(0, 204, 102));
		panel_2.setBounds(235, 0, 1135, 64);
		panel.add(panel_2);

		JLabel lblStock = new JLabel("STOCK");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblStock.setBounds(53, 11, 141, 44);
		panel_2.add(lblStock);

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

		JButton btnNewItem = new JButton("ADD NEW ITEM");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView.this.setVisible(false);
				NewItemView newItem = new NewItemView();
				newItem.setVisible(true);
			}
		});
		btnNewItem.setForeground(new Color(0, 204, 102));
		btnNewItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewItem.setBackground(Color.WHITE);
		btnNewItem.setBounds(10, 213, 216, 42);
		panel_1.add(btnNewItem);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView.this.setVisible(false);
				HomeView homeView = new HomeView();
				homeView.setVisible(true);
			}
		});
		btnHome.setForeground(new Color(0, 204, 102));
		btnHome.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(10, 260, 216, 42);
		panel_1.add(btnHome);

		JButton btnNewItem_1_1 = new JButton("LOGOUT");
		btnNewItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView.this.setVisible(false);
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}
		});
		btnNewItem_1_1.setForeground(new Color(0, 204, 102));
		btnNewItem_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewItem_1_1.setBackground(Color.WHITE);
		btnNewItem_1_1.setBounds(10, 307, 216, 42);
		panel_1.add(btnNewItem_1_1);

		JLabel lblNewLabel = new JLabel("_____________________________________");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 50, 268, 14);
		panel_1.add(lblNewLabel);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView.this.setVisible(false);
				DashboardView dashboardView = new DashboardView();
				dashboardView.setVisible(true);
			}
		});
		btnDashboard.setForeground(new Color(0, 204, 102));
		btnDashboard.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(10, 166, 216, 42);
		panel_1.add(btnDashboard);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(0, 204, 102));
		panel_2_1.setBounds(235, 657, 1135, 64);
		panel.add(panel_2_1);

		JLabel lblDisplayAllProducts = new JLabel("DISPLAY ALL PRODUCTS");
		lblDisplayAllProducts.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisplayAllProducts.setForeground(new Color(0, 204, 102));
		lblDisplayAllProducts.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblDisplayAllProducts.setBackground(Color.WHITE);
		lblDisplayAllProducts.setBounds(287, 92, 355, 64);
		panel.add(lblDisplayAllProducts);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 204, 102));
		scrollPane.setBackground(new Color(0, 204, 102));
		scrollPane.setBorder(new LineBorder(new Color(0, 204, 102)));
		scrollPane.setBounds(287, 167, 512, 441);
		panel.add(scrollPane);

		productTable = new JTable();
		productTable.setRowHeight(25);
		productTable.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		productTable.setGridColor(new Color(255, 255, 255));
		productTable.setForeground(new Color(0, 204, 102));
		productTable.setBackground(new Color(255, 255, 255));
		productTable.setSelectionBackground(new Color(0, 204, 102));
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sr No", "Product Name", "Quantity", "Unit Price", "Total Price", "Date"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		productTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		productTable.getColumnModel().getColumn(0).setMinWidth(20);
		productTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		productTable.getColumnModel().getColumn(1).setMinWidth(20);
		productTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		productTable.getColumnModel().getColumn(2).setMinWidth(20);
		productTable.getColumnModel().getColumn(3).setPreferredWidth(45);
		productTable.getColumnModel().getColumn(3).setMinWidth(20);
		productTable.getColumnModel().getColumn(4).setMinWidth(20);
		scrollPane.setViewportView(productTable);

		JButton btnProductAdd = new JButton("ADD NEW ITEM");
		btnProductAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView.this.setVisible(false);
				NewItemView newItemView = new NewItemView();
				newItemView.setVisible(true);
			}
		});
		btnProductAdd.setForeground(new Color(0, 204, 102));
		btnProductAdd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnProductAdd.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnProductAdd.setBackground(Color.WHITE);
		btnProductAdd.setBounds(809, 245, 153, 29);
		panel.add(btnProductAdd);

		JButton btnProductDelete = new JButton("DELETE");
		btnProductDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProduct();
			}
		});
		btnProductDelete.setForeground(new Color(0, 204, 102));
		btnProductDelete.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnProductDelete.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnProductDelete.setBackground(Color.WHITE);
		btnProductDelete.setBounds(809, 280, 153, 29);
		panel.add(btnProductDelete);

		JButton btnTblRefresh = new JButton("");
		btnTblRefresh.setIcon(new ImageIcon("E:\\Java-WorkSpace\\KSA\\src\\icon\\arrow.png"));
		btnTblRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPartQuantity.setVisible(false);
				lblQuantity.setVisible(false);
				txtPrice.setVisible(false);
				lblPrice.setVisible(false);
				lblTotalPrice.setVisible(false);
				txtTotalPrice.setVisible(false);
				txtVAT.setVisible(false);
				lblTaxVAT.setVisible(false);
				txtPartQuantity.setText("");
				txtPrice.setText("");
				txtTotalPrice.setText("");
				showProductData(); // upon refreshing table
			}
		});
		btnTblRefresh.setForeground(new Color(0, 204, 102));
		btnTblRefresh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTblRefresh.setBorder(null);
		btnTblRefresh.setBackground(Color.WHITE);
		btnTblRefresh.setBounds(809, 175, 37, 29);
		panel.add(btnTblRefresh);

		JButton btnEdit = new JButton("EDIT");

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPartQuantity.setVisible(true);
				lblQuantity.setVisible(true);
				txtPrice.setVisible(true);
				lblPrice.setVisible(true);
				txtTotalPrice.setVisible(true);
				lblTotalPrice.setVisible(true);
				txtVAT.setVisible(true);
				lblTaxVAT.setVisible(true);
				updateProduct();
				showProductData(); // on edit
				txtPartQuantity.setText("");
				txtPrice.setText("");
				txtTotalPrice.setText("");
			}
		});
		btnEdit.setForeground(new Color(0, 204, 102));
		btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEdit.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(809, 315, 153, 29);
		panel.add(btnEdit);

		txtPartQuantity = new JTextField();
		txtPartQuantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotalPrice());
			}
		});
		txtPartQuantity.setBounds(809, 355, 153, 27);
		txtPartQuantity.setVisible(false);
		panel.add(txtPartQuantity);
		txtPartQuantity.setColumns(10);

		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(new Color(0, 204, 102));
		lblQuantity.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblQuantity.setBackground(Color.WHITE);
		lblQuantity.setBounds(963, 355, 87, 27);
		lblQuantity.setVisible(false);
		panel.add(lblQuantity);

		txtPrice = new JTextField();
		txtPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotalPrice());
			}
		});
		txtPrice.setBounds(809, 395, 153, 27);
		txtPrice.setVisible(false);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		lblPrice = new JLabel("Unit Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(0, 204, 102));
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setBounds(963, 395, 87, 27);
		lblPrice.setVisible(false);
		panel.add(lblPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setBounds(809, 475, 153, 27);
		txtTotalPrice.setVisible(false);
		panel.add(txtTotalPrice);
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(10);

		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(new Color(0, 204, 102));
		lblTotalPrice.setVisible(false);
		lblTotalPrice.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTotalPrice.setBackground(Color.WHITE);
		lblTotalPrice.setBounds(963, 475, 87, 27);
		panel.add(lblTotalPrice);

		cmbMonth.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbMonth.setBackground(Color.WHITE);
		cmbMonth.setBounds(645, 128, 153, 28);
		panel.add(cmbMonth);
		String[] months = new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		cmbMonth.setModel(new DefaultComboBoxModel<>(months));

		JLabel lblMonth = new JLabel("Select Month");
		lblMonth.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonth.setForeground(new Color(0, 204, 102));
		lblMonth.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMonth.setBackground(Color.WHITE);
		lblMonth.setBounds(808, 128, 140, 27);
		panel.add(lblMonth);

		JButton btnSum = new JButton("SUM");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateSumOfStock();
			}
		});
		btnSum.setForeground(new Color(0, 204, 102));
		btnSum.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSum.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnSum.setBackground(Color.WHITE);
		btnSum.setBounds(809, 210, 153, 29);
		panel.add(btnSum);

		lblTaxVAT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxVAT.setForeground(new Color(0, 204, 102));
		lblTaxVAT.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTaxVAT.setBackground(Color.WHITE);
		lblTaxVAT.setBounds(963, 437, 87, 27);
		lblTaxVAT.setVisible(false);
		panel.add(lblTaxVAT);

		txtVAT = new JTextField();
		txtVAT.setVisible(false);
		txtVAT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalPrice.setText(calculateTotalPrice());
			}
		});
		txtVAT.setText("15");
		txtVAT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtVAT.setEditable(true);
		txtVAT.setColumns(10);
		txtVAT.setBounds(809, 435, 153, 28);
		panel.add(txtVAT);

		showProductData(); // while initializing the constructor
		cmbMonth.addActionListener(e -> filterDataByMonth());

		addDoubleFilter(txtPartQuantity);
		addDoubleFilter(txtPrice);
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

	public void filterDataByMonth() {
		DefaultTableModel model = (DefaultTableModel) productTable.getModel();
		model.setRowCount(0);
		List<StockDTO> stockList = new ArrayList<>();

		String selectedMonth = (String) cmbMonth.getSelectedItem();
		int selectedMonthIndex = cmbMonth.getSelectedIndex() + 1;

		try {
			stockList = stockController.filterDataByMonth(selectedMonth, selectedMonthIndex);

			for (StockDTO stockDTO : stockList) {
				stockDTO.getSrNo();
				stockDTO.getDateString();
				stockDTO.getPartName();
				stockDTO.getUnitPrice();
				stockDTO.getTotalValue();
				stockDTO.getQuantity();
				Object[] rowData = { stockDTO.getSrNo(), stockDTO.getPartName(), stockDTO.getQuantity(),
						stockDTO.getUnitPrice(), stockDTO.getTotalValue(), stockDTO.getDateString() };
				model.addRow(rowData);
			}
		} catch (Exception ex) {
			handleException(ex, "Error filtering data by month.");
		}
	}

	public void updateProduct() {
		try {
			StockDTO stockDTO = new StockDTO();
			stockDTO.setQuantity(Double.parseDouble(getPartQuantity()));
			stockDTO.setUnitPrice(Double.parseDouble(getPrice()));
			stockDTO.setTotalValue(Double.parseDouble(getTotalValue()));
			stockDTO.setDateString(getDateString());
			
			double newTax = Double.parseDouble(txtVAT.getText());
			int selectedRow = productTable.getSelectedRow();
			int srNo = (int) productTable.getValueAt(selectedRow, 0);

			stockController.updateProduct(newTax, selectedRow, srNo, stockDTO);
			showProductData();
			clearInputFields();
		} catch (NumberFormatException ex) {
//			handleException(ex, "Invalid input for updating product.");
		} catch (Exception ex) {
			handleException(ex, "Error updating product.");
		}
	}

	public String calculateTotalPrice() {
		try {
			double PartQuantityD = Double.parseDouble(getPartQuantity());
			double priceD = Double.parseDouble(getPrice());
			double totalPrice = (PartQuantityD * priceD);
			double VATD = Double.parseDouble(getTaxVAT());
			totalPrice = (totalPrice + (totalPrice * (VATD / 100)));
			String totalPriceF = String.format("%.2f", totalPrice);
			return totalPriceF;

		} catch (NumberFormatException ex) {
			return "";
		}
	}

	public void calculateSumOfStock() {
		int rowCount = productTable.getRowCount();
		int sumTotalExpenses = 4;
		double sumTotalProfit = 0.0;

		for (int row = 0; row < rowCount; row++) {
			Object TotalInv = productTable.getValueAt(row, sumTotalExpenses);
			if (TotalInv instanceof Number) {
				double numericValue = ((Number) TotalInv).doubleValue();
				sumTotalProfit += numericValue;
			}
		}

		try {
			String SumOfStock = String.format("%.2f", sumTotalProfit);
			JOptionPane.showMessageDialog(null, SumOfStock);
		} catch (NumberFormatException ex) {
			handleException(ex, "Error calculating the sum of stock.");
		}
	}

	public void showProductData() {
		DefaultTableModel model = (DefaultTableModel) productTable.getModel();
		model.setRowCount(0);
		List<StockDTO> stockList = new ArrayList<>();

		stockList = stockController.showProductData();
		for (StockDTO stockDTO : stockList) {
			stockDTO.getSrNo();
			stockDTO.getDateString();
			stockDTO.getPartName();
			stockDTO.getUnitPrice();
			stockDTO.getTotalValue();
			stockDTO.getQuantity();
			Object[] rowData = { stockDTO.getSrNo(), stockDTO.getPartName(), stockDTO.getQuantity(),
					stockDTO.getUnitPrice(), stockDTO.getTotalValue(), stockDTO.getDateString() };
			model.addRow(rowData);
		}
	}

	public void deleteProduct() {
		int selectedRow = productTable.getSelectedRow();
		int srNo = (int) productTable.getValueAt(selectedRow, 0);
		DefaultTableModel model = (DefaultTableModel) productTable.getModel();
		stockController.deleteProduct(selectedRow, srNo, model);
	}

	private String getPartQuantity() {
		return txtPartQuantity.getText();
	}

	private String getPrice() {
		return txtPrice.getText();
	}

	private String getTotalValue() {
		return txtTotalPrice.getText();
	}
	
	private String getTaxVAT() {
		return txtVAT.getText();
	}

	private void clearInputFields() {
		txtPartQuantity.setText("");
		txtPrice.setText("");
		txtTotalPrice.setText("");
	}

	private void handleException(Exception ex, String message) {
		ex.printStackTrace(); // Log the exception (you can replace this with a proper logging mechanism)
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public String getDateString() {
		dateString = dateFormat.format(currentDate);
		return dateString;
	}

}
