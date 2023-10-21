package KSA.calculations;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Frame;

public class allCalculation extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3355153584734384462L;

	public allCalculation(double sumQuantity, double sumTotalStock, double sumTotalSale, double sumTotalProfit) {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblDashboard_1 = new JLabel("ورشة المعيصم");
		lblDashboard_1.setBackground(new Color(255, 255, 255));
		lblDashboard_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard_1.setForeground(new Color(0, 204, 102));
		lblDashboard_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblDashboard_1.setBorder(null);
		lblDashboard_1.setBounds(0, 0, 322, 51);
		getContentPane().add(lblDashboard_1);
		
		JLabel lblQuantity = new JLabel("Quantity ");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblQuantity.setBounds(34, 107, 73, 24);
		getContentPane().add(lblQuantity);
		
		JLabel lblNewLabel_1_6 = new JLabel("كمية");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(202, 107, 95, 24);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblQuantity_1 = new JLabel(":");
		lblQuantity_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblQuantity_1.setBounds(99, 107, 23, 24);
		getContentPane().add(lblQuantity_1);
		
		String sq = String.format("%.2f", sumQuantity);
		JLabel lblQuantity1 = new JLabel(sq);
		lblQuantity1.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblQuantity1.setBounds(117, 107, 83, 24);
		getContentPane().add(lblQuantity1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 322, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDashboard_1_1 = new JLabel("احسب المجموع");
		lblDashboard_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDashboard_1_1.setForeground(new Color(0, 204, 102));
		lblDashboard_1_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblDashboard_1_1.setBorder(null);
		lblDashboard_1_1.setBackground(Color.WHITE);
		lblDashboard_1_1.setBounds(10, 51, 302, 51);
		panel.add(lblDashboard_1_1);
		
		JLabel lblTotalStock = new JLabel("Total Stock");
		lblTotalStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalStock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTotalStock.setBounds(33, 142, 73, 24);
		panel.add(lblTotalStock);
		
		JLabel lblQuantity_1_2 = new JLabel(":");
		lblQuantity_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblQuantity_1_2.setBounds(99, 142, 22, 24);
		panel.add(lblQuantity_1_2);
		
		String ts = String.format("%.2f", sumTotalStock);
		JLabel lblTotalStock1 = new JLabel(ts);
		lblTotalStock1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalStock1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTotalStock1.setBounds(116, 143, 83, 24);
		panel.add(lblTotalStock1);
		
		JLabel lblNewLabel_1_8 = new JLabel("القيمة الإجمالية");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(201, 142, 95, 24);
		panel.add(lblNewLabel_1_8);
		
		JLabel lblS = new JLabel("Total Sale");
		lblS.setHorizontalAlignment(SwingConstants.LEFT);
		lblS.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblS.setBounds(33, 177, 72, 24);
		panel.add(lblS);
		
		JLabel lblQuantity_1_3 = new JLabel(":");
		lblQuantity_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblQuantity_1_3.setBounds(98, 177, 23, 24);
		panel.add(lblQuantity_1_3);
		
		String tsale = String.format("%.2f", sumTotalSale);
		JLabel lblTotalSale1 = new JLabel(tsale);
		lblTotalSale1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalSale1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTotalSale1.setBounds(116, 178, 83, 24);
		panel.add(lblTotalSale1);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("إجمالي البيع");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_7_1.setBounds(200, 177, 95, 24);
		panel.add(lblNewLabel_1_7_1);
		
		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProfit.setBounds(33, 212, 73, 24);
		panel.add(lblProfit);
		
		JLabel lblQuantity_1_4 = new JLabel(":");
		lblQuantity_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblQuantity_1_4.setBounds(98, 212, 23, 24);
		panel.add(lblQuantity_1_4);
		
		String p = String.format("%.2f", sumTotalProfit);
		JLabel lblProfit1 = new JLabel(p);
		lblProfit1.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfit1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblProfit1.setBounds(116, 213, 83, 24);
		panel.add(lblProfit1);
		
		JLabel lblNewLabel_1_8_1 = new JLabel("اجمالي الربح");
		lblNewLabel_1_8_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_8_1.setBounds(201, 212, 95, 24);
		panel.add(lblNewLabel_1_8_1);
		
	}

	public static void main(String[] args) {

	}
}
