package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.ShopOrder;
import service.impl.EmployeeServiceImpl;
import service.impl.ShopOrderServiceImpl;
import util.FileUtils;
import util.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	private JTextField textFieldDeleteId;
	private static EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	private static ShopOrderServiceImpl shopOrderServiceImpl = new ShopOrderServiceImpl();
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private JTextField textFieldUpateId;
	private JTextField textFieldEmployeeNo;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagerUI frame = new EmployeeManagerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 345, 822, 144);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("修改資料");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 10, 173, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(230, 51, 64, 23);
		panel_1.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(294, 51, 109, 22);
		panel_1.add(textFieldName);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(435, 51, 64, 23);
		panel_1.add(lblNewLabel_2);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(499, 51, 109, 23);
		panel_1.add(textFieldPassword);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 822, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("員工管理");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(344, 10, 193, 40);
		panel.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("回管理主頁");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeMainUI().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnBack.setBounds(679, 17, 133, 33);
		panel.add(btnBack);
		
		JLabel lblMemberName = new JLabel("");
		lblMemberName.setText("用戶: "+employee.getName());
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		lblMemberName.setBounds(22, 15, 298, 23);
		panel.add(lblMemberName);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 80, 822, 255);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_3 = new JLabel("查詢員工");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(25, 10, 92, 23);
		panel_1_1.add(lblNewLabel_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(128, 128, 128));
		panel_1_2.setBounds(10, 510, 822, 86);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("刪除員工");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_5.setBounds(25, 10, 173, 23);
		panel_1_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(25, 51, 64, 23);
		panel_1_2.add(lblNewLabel_1_2);
		
		textFieldDeleteId = new JTextField();
		textFieldDeleteId.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldDeleteId.setColumns(10);
		textFieldDeleteId.setBounds(89, 51, 109, 22);
		panel_1_2.add(textFieldDeleteId);
		
		JButton btnDelete = new JButton("刪除");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!employee.getUsername().equals("admin")) 
				{	// admin帳號才有刪除的權限
					JOptionPane.showMessageDialog(null, "此帳號無權限刪除。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (textFieldDeleteId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(textFieldDeleteId.getText())) {
					JOptionPane.showMessageDialog(null, "ID不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				int id = Integer.parseInt(textFieldDeleteId.getText());
				Employee employee = employeeServiceImpl.findById(id);
				if(employee == null) {
					JOptionPane.showMessageDialog(null, "此ID員工不存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// 已在訂單裡的員工不能被刪除
				List<ShopOrder> shopOrderList = shopOrderServiceImpl.findByEmployeeNo(employee.getEmployeeNo());
				System.out.println(shopOrderList);
				if(shopOrderList.size()>0) {
					JOptionPane.showMessageDialog(null, "已在訂單裡的員工不能被刪除，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				employeeServiceImpl.delteEmployee(id);
				
				
				JOptionPane.showMessageDialog(null,  "刪除成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnDelete.setBounds(249, 51, 119, 23);
		panel_1_2.add(btnDelete);
		
		JLabel lblAdmin = new JLabel("admin帳號才有刪除的權限");
		lblAdmin.setForeground(new Color(255, 128, 0));
		lblAdmin.setFont(new Font("新細明體", Font.BOLD, 16));
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setBounds(133, 10, 644, 23);
		panel_1_2.add(lblAdmin);
		
		JButton btnSelect = new JButton("查詢");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<Employee> employeeList = new ArrayList<>();
				if(!employee.getUsername().equals("admin")) 
				{	// 一般帳號只能查到自己的資料
					employeeList = employeeServiceImpl.findByUsername(employee.getUsername());
					
				}
				else
				{	// admin帳號可以查到所有的資料
					employeeList = employeeServiceImpl.findAllEmployee();
					
				}
				if(employeeList==null) {
					JOptionPane.showMessageDialog(null,  "查無資料", "完成",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				loadTableData(employeeList);
				
				JOptionPane.showMessageDialog(null,  "查詢成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSelect.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnSelect.setBounds(119, 10, 119, 23);
		panel_1_1.add(btnSelect);
		
		
		
		JButton btnUpdate = new JButton("修改");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textFieldUpateId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(textFieldUpateId.getText())) {
					JOptionPane.showMessageDialog(null, "ID不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int id = Integer.parseInt(textFieldUpateId.getText());
				Employee employee = employeeServiceImpl.findById(id);
				if(employee == null) {
					JOptionPane.showMessageDialog(null, "此ID員工不存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
				String name = null;
				String password = null;
				String employeeNo = null;
				String phone = null;
				String address = null;						

				// 不為空才取值
				if(!textFieldName.getText().isEmpty())
				{
					name = textFieldName.getText();
					employee.setName(name);
				}
				if(!textFieldPassword.getText().isEmpty())
				{
					password = textFieldPassword.getText();
					employee.setPassword(password);
				}	
				if(!textFieldEmployeeNo.getText().isEmpty())
				{
					employeeNo = textFieldEmployeeNo.getText();
					String valMessage = Tool.validateEmployeeNo(employeeNo);
					if(!valMessage.equals("true")) {
						JOptionPane.showMessageDialog(null, valMessage, "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if(new EmployeeServiceImpl().isEmployeeNoBeenUse(employeeNo))
					{	// 員工編號已被使用
						JOptionPane.showMessageDialog(null, "員工編號已存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// 已在訂單裡的員工編號不能被修改
					List<ShopOrder> shopOrderList = shopOrderServiceImpl.findByEmployeeNo(employee.getEmployeeNo());
					System.out.println(shopOrderList);
					if(shopOrderList.size()>0) {
						JOptionPane.showMessageDialog(null, "已在訂單裡的員工編號不能被修改，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					employee.setEmployeeNo(employeeNo);
				}				
				
				if(!textFieldPhone.getText().isEmpty())
				{
					phone = textFieldPhone.getText();
					employee.setPhone(phone);
				}				
				
				if(!textFieldAddress.getText().isEmpty())
				{
					address = textFieldAddress.getText();
					employee.setAddress(address);
				}				
				
				employeeServiceImpl.updateEmployee(employee);
				
				
				JOptionPane.showMessageDialog(null,  "修改成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnUpdate.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnUpdate.setBounds(653, 51, 119, 23);
		panel_1.add(btnUpdate);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(25, 51, 64, 23);
		panel_1.add(lblNewLabel_1_3);
		
		textFieldUpateId = new JTextField();
		textFieldUpateId.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldUpateId.setColumns(10);
		textFieldUpateId.setBounds(89, 51, 109, 22);
		panel_1.add(textFieldUpateId);
		
		JLabel lblAdminadmin = new JLabel("一般帳號只能查到自己的資料, admin帳號可以查到所有的員工(帳號admin,密碼123)");
		lblAdminadmin.setForeground(new Color(255, 128, 0));
		lblAdminadmin.setBackground(new Color(255, 255, 255));
		lblAdminadmin.setFont(new Font("新細明體", Font.BOLD, 16));
		lblAdminadmin.setBounds(122, 9, 644, 23);
		panel_1.add(lblAdminadmin);
		
		textFieldEmployeeNo = new JTextField();
		textFieldEmployeeNo.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldEmployeeNo.setColumns(10);
		textFieldEmployeeNo.setBounds(89, 89, 109, 22);
		panel_1.add(textFieldEmployeeNo);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("編號");
		lblNewLabel_1_3_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(25, 89, 64, 23);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("電話");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(230, 89, 64, 23);
		panel_1.add(lblNewLabel_1_1);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(294, 89, 109, 22);
		panel_1.add(textFieldPhone);
		
		JLabel lblNewLabel_2_1 = new JLabel("地址");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(435, 89, 64, 23);
		panel_1.add(lblNewLabel_2_1);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(499, 89, 109, 23);
		panel_1.add(textFieldAddress);
		
		
		// JTable輸出		
		// 表格標題
        String[] columnNames = {"ID", "編號", "員工帳號","員工密碼", "名字", "電話", "地址", "修改時間", "建立時間"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        // 設定欄位寬度
        table.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(60);  // 編號
        table.getColumnModel().getColumn(2).setPreferredWidth(120); // 員工帳號
        table.getColumnModel().getColumn(3).setPreferredWidth(120); // 員工密碼
        table.getColumnModel().getColumn(4).setPreferredWidth(120); // 名字
        table.getColumnModel().getColumn(5).setPreferredWidth(120); // 電話
        table.getColumnModel().getColumn(6).setPreferredWidth(120); // 地址
        table.getColumnModel().getColumn(7).setPreferredWidth(200); // 
        table.getColumnModel().getColumn(8).setPreferredWidth(200); // 
        
        // 設定表格不可編輯
        table.setDefaultEditor(Object.class, null);               

        // 加入 JScrollPane（滾動條）
        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setBounds(12, 45, 795, 200);
        panel_1_1.add(scrollPaneTable, BorderLayout.CENTER);               
     
	}
	
    
	// 載入 List 到 JTable
    private void loadTableData(List<Employee> employees) {
        model.setRowCount(0); // 清空表格
        for (Employee e : employees) {
            model.addRow(new Object[]{
                e.getId(),
                e.getEmployeeNo(),
                e.getUsername(),
                e.getPassword(),
                e.getName(),
                e.getPhone(),
                e.getAddress(),
                Tool.formatTimestamp(e.getCreatedAt()),
                Tool.formatTimestamp(e.getUpdatedAt())
            });
        }
    }
}
