package KSA.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import KSA.calculations.allCalculation;
import KSA.controller.DashboardController;
import KSA.dto.InvoiceDTO;

public class DashboardView extends JFrame implements Printable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7514457540861649295L;
	private JTable invoiceTable;
	private JTextField txtSearchCust;
	private JRadioButton rdBtnPaid = new JRadioButton("Paid");
	private JRadioButton rdBtnUnpaid = new JRadioButton("UnPaid");
	private JComboBox<String> cmbMonthTo = new JComboBox<>();
	private JComboBox<String> cmbYearTo = new JComboBox<>();
	private JComboBox<String> cmbMonthFrom = new JComboBox<>();
	private JComboBox<String> cmbYearFrom = new JComboBox<>();
	private JComboBox<String> cmbPartName = new JComboBox<>();

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
	private String paid;
	private String setPaid;
	private int selectedRow;
	private int invNoSelected;
	private String checkpaid;

	private int FromMonth;
	private String FromYear;
	private int ToMonth;
	private String ToYear;

	private DashboardController dashboardController = new DashboardController();

	public DashboardView() {

		setTitle("YOUR SHOP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java-WorkSpace\\KSA\\src\\icon\\iconWindow.jpg"));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1371, 706);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				JLabel lblCustomer = new JLabel("CUSTOMER :");
				lblCustomer.setHorizontalAlignment(SwingConstants.LEFT);
				lblCustomer.setForeground(new Color(0, 204, 102));
				lblCustomer.setFont(new Font("Segoe UI", Font.BOLD, 13));
				lblCustomer.setBackground(Color.WHITE);
				lblCustomer.setBounds(381, 86, 87, 27);
				panel.add(lblCustomer);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(0, 204, 102));
		panel_2.setBounds(0, 0, 1370, 64);
		panel.add(panel_2);

		JLabel lblRecords = new JLabel("RECORDS");
		lblRecords.setForeground(Color.WHITE);
		lblRecords.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRecords.setBounds(311, 11, 141, 44);
		panel_2.add(lblRecords);

		JLabel lblMain = new JLabel("YOUR SHOP");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setForeground(Color.WHITE);
		lblMain.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblMain.setBorder(null);
		lblMain.setBounds(22, 4, 216, 51);
		panel_2.add(lblMain);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardView.this.setVisible(false);
				HomeView homeView = new HomeView();
				homeView.setVisible(true);
			}
		});
		btnHome.setForeground(new Color(0, 204, 102));
		btnHome.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(680, 11, 216, 42);
		panel_2.add(btnHome);

		JButton btnNewItem = new JButton("ADD NEW ITEM");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardView.this.setVisible(false);
				NewItemView newItemView = new NewItemView();
				newItemView.setVisible(true);
			}
		});
		btnNewItem.setForeground(new Color(0, 204, 102));
		btnNewItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewItem.setBackground(Color.WHITE);
		btnNewItem.setBounds(906, 11, 216, 42);
		panel_2.add(btnNewItem);

		JButton btnStock = new JButton("STOCK");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardView.this.setVisible(false);
				StockView stockView = new StockView();
				stockView.setVisible(true);
			}
		});
		btnStock.setForeground(new Color(0, 204, 102));
		btnStock.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnStock.setBackground(Color.WHITE);
		btnStock.setBounds(1132, 11, 216, 42);
		panel_2.add(btnStock);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(0, 204, 102));
		panel_2_1.setBounds(0, 642, 1370, 64);
		panel.add(panel_2_1);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardView.this.setVisible(false);
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
				;
			}
		});
		btnLogout.setForeground(new Color(0, 204, 102));
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(1140, 11, 216, 42);
		panel_2_1.add(btnLogout);

		JButton btnHome2 = new JButton("HOME");
		btnHome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardView.this.setVisible(false);
				HomeView homeView = new HomeView();
				homeView.setVisible(true);
			}
		});
		btnHome2.setForeground(new Color(0, 204, 102));
		btnHome2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHome2.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnHome2.setBackground(Color.WHITE);
		btnHome2.setBounds(10, 18, 153, 29);
		panel_2_1.add(btnHome2);

		JButton btnProductDelete = new JButton("DELETE");
		btnProductDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invDelete();
				showCustomData();
			}
		});
		btnProductDelete.setForeground(new Color(0, 204, 102));
		btnProductDelete.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnProductDelete.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnProductDelete.setBackground(Color.WHITE);
		btnProductDelete.setBounds(166, 18, 153, 29);
		panel_2_1.add(btnProductDelete);

		JButton btnSum = new JButton("SUM");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateSum();
			}
		});
		btnSum.setForeground(new Color(0, 204, 102));
		btnSum.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSum.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnSum.setBackground(Color.WHITE);
		btnSum.setBounds(322, 18, 153, 29);
		panel_2_1.add(btnSum);

		JButton btnPaid = new JButton("PAID");
		btnPaid.setVisible(false);
		btnPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPaid();
				showCustomData();
			}
		});
		btnPaid.setForeground(new Color(0, 204, 102));
		btnPaid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnPaid.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnPaid.setBackground(Color.WHITE);
		btnPaid.setBounds(634, 18, 153, 29);
		panel_2_1.add(btnPaid);

		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printInvoice();
			}
		});
		btnPrint.setForeground(new Color(0, 204, 102));
		btnPrint.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnPrint.setBorder(new LineBorder(new Color(0, 204, 102), 2));
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(478, 18, 153, 29);
		panel_2_1.add(btnPrint);

		JLabel lblDisplayAllRecords = new JLabel("DISPLAY ALL RECORDS");
		lblDisplayAllRecords.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisplayAllRecords.setForeground(new Color(0, 204, 102));
		lblDisplayAllRecords.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblDisplayAllRecords.setBackground(Color.WHITE);
		lblDisplayAllRecords.setBounds(34, 75, 339, 64);
		panel.add(lblDisplayAllRecords);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 204, 102)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(0, 204, 102));
		scrollPane.setBounds(10, 159, 1346, 472);
		panel.add(scrollPane);

		invoiceTable = new JTable();
		invoiceTable.setRowHeight(25);
		invoiceTable.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		invoiceTable.setSelectionBackground(new Color(0, 204, 102));
		invoiceTable.setGridColor(new Color(255, 255, 255));
		invoiceTable.setBackground(new Color(255, 255, 255));
		invoiceTable.setForeground(new Color(0, 204, 102));
		invoiceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Inv No", "Date", "Customer Name", "M/S", "Product Name", "Description", "Quantity", "Unit Price", "Discount", "Tax", "Total Price", "Stock "
			}
		));
		invoiceTable.getColumnModel().getColumn(0).setPreferredWidth(45);
		invoiceTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		invoiceTable.getColumnModel().getColumn(6).setPreferredWidth(30);
		invoiceTable.getColumnModel().getColumn(7).setPreferredWidth(50);
		invoiceTable.getColumnModel().getColumn(8).setPreferredWidth(30);
		invoiceTable.getColumnModel().getColumn(9).setPreferredWidth(25);
		scrollPane.setViewportView(invoiceTable);

		JButton btnTblRefresh = new JButton("");
		btnTblRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInvoiceData();
			}
		});
		btnTblRefresh.setIcon(new ImageIcon("E:\\Java-WorkSpace\\KSA\\src\\icon\\arrow.png"));
		btnTblRefresh.setForeground(new Color(0, 204, 102));
		btnTblRefresh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTblRefresh.setBorder(null);
		btnTblRefresh.setBackground(Color.WHITE);
		btnTblRefresh.setBounds(371, 86, 52, 48);
		panel.add(btnTblRefresh);

		JLabel lblPartName = new JLabel("PART NAME :");
		lblPartName.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartName.setForeground(new Color(0, 204, 102));
		lblPartName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPartName.setBackground(Color.WHITE);
		lblPartName.setBounds(690, 86, 87, 27);
		panel.add(lblPartName);

		txtSearchCust = new JTextField();
		txtSearchCust.setColumns(10);
		txtSearchCust.setBounds(465, 86, 221, 28);
		panel.add(txtSearchCust);
		txtSearchCust.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c)) {
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

		JButton btnCust = new JButton("SEARCH");
		btnCust.setForeground(new Color(255, 255, 255));
		btnCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCustomData();
			}
		});
		btnCust.setBackground(new Color(0, 204, 102));
		btnCust.setBounds(583, 117, 102, 28);
		panel.add(btnCust);
		rdBtnPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdBtnUnpaid.isSelected()) {
					rdBtnUnpaid.setSelected(false);
					btnPaid.setVisible(false);
				}
				if (rdBtnPaid.isSelected()) {
					showCustomData();
				} else if (!rdBtnPaid.isSelected() || !rdBtnUnpaid.isSelected()) {
					showInvoiceData();
				}
			}
		});

		rdBtnPaid.setName("paid");
		rdBtnPaid.setForeground(new Color(0, 204, 102));
		rdBtnPaid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdBtnPaid.setBackground(Color.WHITE);
		rdBtnPaid.setBounds(1243, 86, 71, 23);
		panel.add(rdBtnPaid);
		rdBtnPaid.setSelected(true);

		rdBtnUnpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdBtnPaid.isSelected()) {
					rdBtnPaid.setSelected(false);
					btnPaid.setVisible(true);
				}
				if (!rdBtnUnpaid.isSelected()) {
					btnPaid.setVisible(false);
				}
				if (rdBtnUnpaid.isSelected()) {
					showCustomData();
				} else if (!rdBtnPaid.isSelected() || !rdBtnUnpaid.isSelected()) {
					showInvoiceData();
				}
			}
		});

		rdBtnUnpaid.setName("unpaid");
		rdBtnUnpaid.setForeground(new Color(0, 204, 102));
		rdBtnUnpaid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdBtnUnpaid.setBackground(Color.WHITE);
		rdBtnUnpaid.setBounds(1243, 117, 127, 23);
		panel.add(rdBtnUnpaid);

		cmbMonthTo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbMonthTo.setBackground(Color.WHITE);
		cmbMonthTo.setBounds(999, 117, 109, 28);
		panel.add(cmbMonthTo);
		String[] months = new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		cmbMonthTo.setModel(new DefaultComboBoxModel<>(months));
		cmbMonthTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateDates();
			}
		});
		cmbPartName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCustomData();
			}
		});

		cmbPartName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbPartName.setBackground(Color.WHITE);
		cmbPartName.setBounds(781, 85, 160, 28);
		panel.add(cmbPartName);

		cmbYearTo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbYearTo.setBackground(Color.WHITE);
		cmbYearTo.setBounds(1118, 117, 102, 28);
		panel.add(cmbYearTo);
		String[] years = new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032",
				"2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045",
				"2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058",
				"2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071",
				"2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084",
				"2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097",
				"2098", "2099", "2100" };
		cmbYearTo.setModel(new DefaultComboBoxModel<>(years));

		cmbYearFrom.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbYearFrom.setBackground(Color.WHITE);
		cmbYearFrom.setBounds(1118, 86, 102, 28);
		panel.add(cmbYearFrom);
		cmbYearFrom.setModel(new DefaultComboBoxModel<>(years));
		cmbMonthFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateDates();
			}
		});

		cmbMonthFrom.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbMonthFrom.setBackground(Color.WHITE);
		cmbMonthFrom.setBounds(999, 86, 109, 28);
		panel.add(cmbMonthFrom);
		cmbMonthFrom.setModel(new DefaultComboBoxModel<>(months));
		
		JLabel lblFromDate = new JLabel("FROM :");
		lblFromDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFromDate.setForeground(new Color(0, 204, 102));
		lblFromDate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblFromDate.setBackground(Color.WHITE);
		lblFromDate.setBounds(909, 88, 87, 27);
		panel.add(lblFromDate);
		
		JLabel lblToDate = new JLabel("TO : ");
		lblToDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToDate.setForeground(new Color(0, 204, 102));
		lblToDate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblToDate.setBackground(Color.WHITE);
		lblToDate.setBounds(909, 115, 87, 27);
		panel.add(lblToDate);

		showInvoiceData();
		populateCmbProductBox();
		cmbMonthTo.addActionListener(e -> filterDataByMonth());
		cmbYearTo.addActionListener(e -> filterDataByMonth());

	}

	public List<String> getProductsName() {
		return dashboardController.getProductsName();
	}

	public void invDelete() {
		int selectedRow = invoiceTable.getSelectedRow();
		int invNo = (int) invoiceTable.getValueAt(selectedRow, 0);
		dashboardController.invDelete(selectedRow, invNo);
	}

	public void setPaid() {
		int selectedRow = invoiceTable.getSelectedRow();
		int invNo = (int) invoiceTable.getValueAt(selectedRow, 0);
		dashboardController.setPaid(selectedRow, invNo);
	}

	public void populateCmbProductBox() {
		List<String> productsName = getProductsName();
		for (String productName : productsName) {
			cmbPartName.addItem(productName);
		}
	}

	public void validateDates() {
		FromMonth = cmbMonthFrom.getSelectedIndex() + 1;
		FromYear = (String) cmbYearFrom.getSelectedItem();
		ToMonth = cmbMonthTo.getSelectedIndex() + 1;
		ToYear = (String) cmbYearTo.getSelectedItem();
		
		if (FromMonth == 0 || FromYear.equals("0") || ToMonth == 0 || ToYear.equals("0")) {
			return; // Missing date selections, do nothing
		}
	}

	public void showInvoiceData() {
		DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
		 model.setRowCount(0);
		InvoiceDTO invoiceDTO = new InvoiceDTO();

		if (rdBtnPaid.isSelected()) {
			checkpaid = rdBtnPaid.getName();
		} else if (rdBtnUnpaid.isSelected()) {
			checkpaid = rdBtnUnpaid.getName();
		} else {
			checkpaid = null;
		}
		invoiceDTO.setCheckpaid(checkpaid);
		List<InvoiceDTO> invoiceList = dashboardController.showInvoiceData(invoiceDTO);
		try {
			for (InvoiceDTO invoiceDTO1 : invoiceList) {

				invoiceDTO1.getInvNo();
				invoiceDTO1.getDateString();
				invoiceDTO1.getCustName();
				invoiceDTO1.getMS();
				invoiceDTO1.getPartName();
				invoiceDTO1.getDescription();
				invoiceDTO1.getquantity();
				invoiceDTO1.getUnitPrice();
				invoiceDTO1.getTotalValue();
				invoiceDTO1.getDiscount();
				invoiceDTO1.getNetInvoice();
				invoiceDTO1.getTaxVAT();
				invoiceDTO1.getTotalInv();
				invoiceDTO1.getPaid();
				invoiceDTO1.getRealStockF();
				Object[] rowData = { invoiceDTO1.getInvNo(), invoiceDTO1.getDateString(), invoiceDTO1.getCustName(),
						invoiceDTO1.getMS(), invoiceDTO1.getPartName(), invoiceDTO1.getDescription(),
						invoiceDTO1.getquantity(), invoiceDTO1.getUnitPrice(), invoiceDTO1.getDiscount(),
						invoiceDTO1.getTaxVAT(), invoiceDTO1.getTotalInv(), invoiceDTO1.getRealStockF() };
				model.addRow(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCustomData() {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		String customer = txtSearchCust.getText().trim();
		String partName = (String) cmbPartName.getSelectedItem();
		DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
		model.setRowCount(0);
		List<InvoiceDTO> invoiceList;
		if (rdBtnPaid.isSelected()) {
			checkpaid = rdBtnPaid.getName();
		} else if (rdBtnUnpaid.isSelected()) {
			checkpaid = rdBtnUnpaid.getName();
		}

		invoiceDTO.setCheckpaid(checkpaid);

		if (customer.isEmpty()) {
			if (partName.isEmpty()) {
				invoiceList = dashboardController.showInvoiceData(invoiceDTO);
			} else {
				invoiceList = dashboardController.showProductData(invoiceDTO, partName);
			}
		} else {
			invoiceList = dashboardController.showCustomerData(invoiceDTO, customer);
		}
		try {
			for (InvoiceDTO invoiceDTO1 : invoiceList) {

				invoiceDTO1.getInvNo();
				invoiceDTO1.getDateString();
				invoiceDTO1.getCustName();
				invoiceDTO1.getMS();
				invoiceDTO1.getPartName();
				invoiceDTO1.getDescription();
				invoiceDTO1.getquantity();
				invoiceDTO1.getUnitPrice();
				invoiceDTO1.getTotalValue();
				invoiceDTO1.getDiscount();
				invoiceDTO1.getNetInvoice();
				invoiceDTO1.getTaxVAT();
				invoiceDTO1.getTotalInv();
				invoiceDTO1.getPaid();
				invoiceDTO1.getRealStockF();
				Object[] rowData = { invoiceDTO1.getInvNo(), invoiceDTO1.getDateString(), invoiceDTO1.getCustName(),
						invoiceDTO1.getMS(), invoiceDTO1.getPartName(), invoiceDTO1.getDescription(),
						invoiceDTO1.getquantity(), invoiceDTO1.getUnitPrice(), invoiceDTO1.getDiscount(),
						invoiceDTO1.getTaxVAT(), invoiceDTO1.getTotalInv(), invoiceDTO1.getRealStockF() };
				model.addRow(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void filterDataByMonth() {
		DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
		model.setRowCount(0);
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		validateDates();

		String fromDate = FromMonth + "-" + FromYear;
		String toDate = ToMonth + "-" + ToYear;

		if (rdBtnPaid.isSelected()) {
			checkpaid = rdBtnPaid.getName();
		} else if (rdBtnUnpaid.isSelected()) {
			checkpaid = rdBtnUnpaid.getName();
		}
		invoiceDTO.setCheckpaid(checkpaid);

		if (rdBtnPaid.isSelected() || rdBtnUnpaid.isSelected()) {
			invoiceList = dashboardController.filterDataByMonth(invoiceDTO, fromDate, toDate);
		}

		try {
			for (InvoiceDTO invoiceDTO1 : invoiceList) {

				invoiceDTO1.getInvNo();
				invoiceDTO1.getDateString();
				invoiceDTO1.getCustName();
				invoiceDTO1.getMS();
				invoiceDTO1.getPartName();
				invoiceDTO1.getDescription();
				invoiceDTO1.getquantity();
				invoiceDTO1.getUnitPrice();
				invoiceDTO1.getTotalValue();
				invoiceDTO1.getDiscount();
				invoiceDTO1.getNetInvoice();
				invoiceDTO1.getTaxVAT();
				invoiceDTO1.getTotalInv();
				invoiceDTO1.getPaid();
				invoiceDTO1.getRealStockF();
				Object[] rowData = { invoiceDTO1.getInvNo(), invoiceDTO1.getDateString(), invoiceDTO1.getCustName(),
						invoiceDTO1.getMS(), invoiceDTO1.getPartName(), invoiceDTO1.getDescription(),
						invoiceDTO1.getquantity(), invoiceDTO1.getUnitPrice(), invoiceDTO1.getDiscount(),
						invoiceDTO1.getTaxVAT(), invoiceDTO1.getTotalInv(), invoiceDTO1.getRealStockF() };
				model.addRow(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public void calculateSum() {
		int columnQuantity = 6;
		int columnTotalSale = 10;
		int columnTotalStock = 11;

		int[] selectedRows = invoiceTable.getSelectedRows();

		if (selectedRows.length == 0) {
			// No rows selected, perform calculation on all rows
			int rowCount = invoiceTable.getRowCount();
			double sumTotalSale = 0.0;
			double sumQuantity = 0.0;
			double sumTotalStock = 0.0;
			double sumTotalProfit = 0.0;

			for (int row = 0; row < rowCount; row++) {
				Object totalInv = invoiceTable.getValueAt(row, columnTotalSale);
				Object quantity = invoiceTable.getValueAt(row, columnQuantity);
				Object totalStock = invoiceTable.getValueAt(row, columnTotalStock);

				if (totalInv instanceof Number && quantity instanceof Number && totalStock instanceof Number) {
					double numericValueInv = ((Number) totalInv).doubleValue();
					double numericValueQty = ((Number) quantity).doubleValue();
					double numericValueStock = ((Number) totalStock).doubleValue();

					sumTotalSale += numericValueInv;
					sumQuantity += numericValueQty;
					sumTotalStock += numericValueStock;
					sumTotalProfit += (numericValueInv - numericValueStock);
				}
			}

			allCalculation ac = new allCalculation(sumQuantity, sumTotalStock, sumTotalSale, sumTotalProfit);
			ac.setVisible(true);
		} else {
			// Perform calculation on selected rows
			double sumTotalSale = 0.0;
			double sumQuantity = 0.0;
			double sumTotalStock = 0.0;
			double sumTotalProfit = 0.0;

			for (int selectedRow : selectedRows) {
				Object totalInv = invoiceTable.getValueAt(selectedRow, columnTotalSale);
				Object quantity = invoiceTable.getValueAt(selectedRow, columnQuantity);
				Object totalStock = invoiceTable.getValueAt(selectedRow, columnTotalStock);

				if (totalInv instanceof Number && quantity instanceof Number && totalStock instanceof Number) {
					double numericValueInv = ((Number) totalInv).doubleValue();
					double numericValueQty = ((Number) quantity).doubleValue();
					double numericValueStock = ((Number) totalStock).doubleValue();

					sumTotalSale += numericValueInv;
					sumQuantity += numericValueQty;
					sumTotalStock += numericValueStock;
					sumTotalProfit += (numericValueInv - numericValueStock);
				}
			}

			allCalculation ac = new allCalculation(sumQuantity, sumTotalStock, sumTotalSale, sumTotalProfit);
			ac.setVisible(true);
		}
	}

	public void printInvoice() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);

		try {
			selectedRow = invoiceTable.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "Error", "Select a Record", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				invNoSelected = (int) invoiceTable.getValueAt(selectedRow, 0);
				job.print();
			}
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		InvoiceDTO invoiceDTO;
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		if (invNoSelected > 0) {
			invoiceDTO = dashboardController.print(invNoSelected);
		} else {
			return 0;
		}

		invNo = invoiceDTO.getInvNo();
		dateString = invoiceDTO.getDateString();
		custName = invoiceDTO.getCustName();
		MS = invoiceDTO.getMS();
		partName = invoiceDTO.getPartName();
		quantity = invoiceDTO.getquantity();
		unitPrice = invoiceDTO.getUnitPrice();
		totalValue = invoiceDTO.getTotalValue();
		discount = invoiceDTO.getDiscount();
		netInvoice = invoiceDTO.getNetInvoice();
		taxVAT = invoiceDTO.getTaxVAT();
		totalInv = invoiceDTO.getTotalInv();
		paid = invoiceDTO.getPaid();

		String Paid = "paid";
		if (paid.equals(Paid)) {
			setPaid = "Paid";
		} else {
			setPaid = "UnPaid";
		}
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		Font titleFont = new Font("Arial", Font.BOLD, 35);
		Font regFont = new Font("Arial", Font.PLAIN, 12);

		// Set color
		Color titleColor = Color.GREEN;

		// Use the graphics object to draw your invoice content
		// You can use the provided instance variables to access the data

		// Example usage:
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

		g2d.drawString("Invoice No", 390, 120);
		g2d.drawString("" + invNo, 390, 140);

		g2d.drawString("Date", 270, 120);
		g2d.drawString("" + dateString, 260, 140);

		g2d.drawString("Customer Name", 160, 120);
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
		g2d.drawString("Tax", 380, 200);

		g2d.drawString("" + totalInv, 220, 220);
		g2d.drawString("Total Net Price", 220, 200);

		g2d.drawString("حالة", 80, 200);
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
}
