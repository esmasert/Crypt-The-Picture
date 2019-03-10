import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FirstWB extends JFrame {

	private JPanel ctpMainContent;
	private JButton btnOpen;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton editButton;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		int newWidth = ((int) lblNewLabel.getWidth());
		int newHeight = ((int) lblNewLabel.getHeight());
		int originalWidth = img.getWidth(this);
		int originalHeight = img.getHeight(this);
		int iWidth = originalWidth;
		int iHeight = originalHeight;
		if(iWidth >= iHeight) {
			while(iWidth != newWidth) {
				iWidth = iWidth-1;
				iHeight = iHeight-1;
			}
		}
		else if(iHeight >= iWidth) {
			while(iHeight != newHeight) {
				iWidth = iWidth-1;
				iHeight = iHeight-1;
			}
		}
		Image newImg = img.getScaledInstance(iWidth, iHeight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		System.out.println(iWidth + " " + iHeight);
		System.out.println(originalWidth + " " + originalHeight);
		return image;
	}
	
	//main is here 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWB frame = new FirstWB();
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
	public FirstWB() {
		initComponents();
		createEvents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("CryptPicture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		ctpMainContent = new JPanel();
		ctpMainContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMainContent);
		
		JLabel lblPleaseChoose = new JLabel("PLEASE CHOOSE A PHOTO FROM YOUR COMPUTER");
		lblPleaseChoose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnOpen = new JButton("OPEN");
		btnOpen.setBackground(UIManager.getColor("Button.background"));
		
		lblNewLabel = new JLabel("");
		
		btnNewButton = new JButton("ENCRYPT");

		JButton btnDecrypt = new JButton("DECRYPT");
		
		JLabel lblChooseYourMethod = new JLabel("Click your method: ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblKey = new JLabel("Key :");
		
		editButton = new JButton("EDIT PHOTO");
		editButton.setBackground(UIManager.getColor("Button.background"));
		
		GroupLayout gl_ctpMainContent = new GroupLayout(ctpMainContent);
		gl_ctpMainContent.setHorizontalGroup(
			gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMainContent.createSequentialGroup()
					.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_ctpMainContent.createSequentialGroup()
									.addComponent(lblKey)
									.addGap(20)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnOpen, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(56)
							.addComponent(lblChooseYourMethod)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnDecrypt))
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_ctpMainContent.setVerticalGroup(
			gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMainContent.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpen)
						.addComponent(lblChooseYourMethod)
						.addComponent(btnNewButton)
						.addComponent(btnDecrypt))
					.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editButton))
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKey)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ctpMainContent.setLayout(gl_ctpMainContent);

	}

	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				JFileChooser ch = new JFileChooser();
				ch.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
				ch.addChoosableFileFilter(filter);
				int result = ch.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = ch.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblNewLabel.setIcon(ResizeImage(path));
				}
				else if(result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "No File Selected!");
				}				
			}
		});
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paint sw = new Paint();
				sw.init();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}
