import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FirstWB extends JFrame {

	private JPanel ctpMainContent;
	private JButton btnOpen;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton editButton;
	private JButton ButtonEncrypt;
    public JFileChooser ch = new JFileChooser();
    public File selectedFile = ch.getSelectedFile();
    public String path = selectedFile.getAbsolutePath();

    public pixListAsil pixListFile;

	//public setImage encImage;

	//public Icon encyrptedImage = new ImageIcon("/Users/esmasert/Desktop/LALA.png");


    /**
	 * Launch the application.
	 */
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
        return image;
	}

    ImageIcon picture;


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

        System.out.println(" OLUYOR MU? ");

        //pixListFile = new pixListAsil();
        //encImage = new setImage();

    }

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("CryptPicture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		ctpMainContent = new JPanel();
		ctpMainContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMainContent);
		
		JLabel lblPleaseChoose = new JLabel("PLEASE CHOOSE A PHOTO FROM YOUR COMPUTER");
		lblPleaseChoose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnOpen = new JButton("OPEN");
		btnOpen.setBackground(UIManager.getColor("Button.background"));
		
		lblNewLabel = new JLabel("");
		
		JRadioButton rdbtnAesadvancedEncryption = new JRadioButton("AES (Advanced Encryption Systems)");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Other");
		
		ButtonEncrypt = new JButton("ENCRYPT");

		JButton btnDecrypt = new JButton("DECRYPT");
		
		JLabel lblChooseYourMethod = new JLabel("Choose your method, then click for encrypt or decrypt :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblKey = new JLabel("Key :");
		
		editButton = new JButton("EDIT PHOTO");
		editButton.setBackground(UIManager.getColor("Button.background"));
		
		GroupLayout gl_ctpMainContent = new GroupLayout(ctpMainContent);
		gl_ctpMainContent.setHorizontalGroup(
			gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMainContent.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnAesadvancedEncryption)
						.addComponent(rdbtnNewRadioButton)
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addComponent(ButtonEncrypt)
							.addGap(18)
							.addComponent(btnDecrypt))
						.addComponent(lblChooseYourMethod)
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_ctpMainContent.createSequentialGroup()
									.addComponent(lblKey)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnOpen, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_ctpMainContent.setVerticalGroup(
			gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMainContent.createSequentialGroup()
					.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpen))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKey)
								.addComponent(editButton))
							.addGap(47)
							.addComponent(lblChooseYourMethod)
							.addGap(30)
							.addComponent(rdbtnAesadvancedEncryption)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton)
							.addGap(48)
							.addGroup(gl_ctpMainContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(ButtonEncrypt)
								.addComponent(btnDecrypt)))
						.addGroup(gl_ctpMainContent.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
					.addContainerGap())
		);
		ctpMainContent.setLayout(gl_ctpMainContent);

	}

    private void createEvents() {
		// TODO Auto-generated method stub
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
				ch.addChoosableFileFilter(filter);
				int result = ch.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
                    lblNewLabel.setIcon(ResizeImage(path));
				}
				else if(result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "No File Selected!");
				}				
			}
		});
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SecondWindow sw = new SecondWindow();
				//sw.NewScreen();
			}
		});
		
		ButtonEncrypt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //lblNewLabel.setIcon((Icon) encImage.getEncyptedPicture());

            }
		});

	}

}
