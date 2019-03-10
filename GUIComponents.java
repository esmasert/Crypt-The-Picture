
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUIComponents {

    public static setImage encImage;
    public static String temp;


    static JPanel ctpMainContent = new JPanel();
    static JButton btnOpen = new JButton();
    static JLabel lblNewLabel = new JLabel();
    static JTextField textField = new JTextField();
    static JButton editButton = new JButton();
    static JButton btnNewButton = new JButton();
    static JRadioButton rdbtnAesadvancedEncryption = new JRadioButton();

    public static ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    public GUIComponents() {

        JPanel panel = new JPanel();


        JLabel lblPleaseChoose = new JLabel("PLEASE CHOOSE A PHOTO FROM YOUR COMPUTER");
        lblPleaseChoose.setFont(new Font("Tahoma", Font.PLAIN, 12));

        btnOpen = new JButton("OPEN");
        btnOpen.setBackground(UIManager.getColor("Button.background"));

        lblNewLabel = new JLabel("");

        rdbtnAesadvancedEncryption = new JRadioButton("AES (Advanced Encryption Systems)");

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Other");

        btnNewButton = new JButton("ENCRYPT");

        JButton btnDecrypt = new JButton("DECRYPT");

        JLabel lblChooseYourMethod = new JLabel("Choose your method, then click for encrypt or decrypt :");

        textField = new JTextField();
        textField.setColumns(10);

        JLabel lblKey = new JLabel("Key :");

        editButton = new JButton("EDIT PHOTO");
        editButton.setBackground(UIManager.getColor("Button.background"));

        GroupLayout gl_ctpMainContent = new GroupLayout(ctpMainContent);
        gl_ctpMainContent.setHorizontalGroup(
                gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                .addGap(24)
                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rdbtnAesadvancedEncryption)
                                        .addComponent(rdbtnNewRadioButton)
                                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                                .addComponent(btnNewButton)
                                                .addGap(18)
                                                .addComponent(btnDecrypt))
                                        .addComponent(lblChooseYourMethod)
                                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                                                .addComponent(lblKey)
                                                                .addGap(18)
                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(editButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnOpen, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))))
                                .addGap(18)
                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_ctpMainContent.setVerticalGroup(
                gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                                .addGap(29)
                                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblPleaseChoose, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnOpen))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblKey)
                                                        .addComponent(editButton))
                                                .addGap(47)
                                                .addComponent(lblChooseYourMethod)
                                                .addGap(30)
                                                .addComponent(rdbtnAesadvancedEncryption)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rdbtnNewRadioButton)
                                                .addGap(48)
                                                .addGroup(gl_ctpMainContent.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(btnDecrypt)))
                                        .addGroup(gl_ctpMainContent.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        ctpMainContent.setLayout(gl_ctpMainContent);


        panel.add(lblPleaseChoose);
        panel.add(btnOpen);
        panel.add(lblNewLabel);
        panel.add(rdbtnAesadvancedEncryption);
        panel.add(rdbtnNewRadioButton);
        panel.add(btnNewButton);
        panel.add(btnDecrypt);
        panel.add(lblChooseYourMethod);
        panel.add(textField);
        panel.add(lblKey);
        panel.add(editButton);
        panel.add(ctpMainContent);



        JFrame frame = new JFrame(); // Create a frame
        frame.add(panel); // Add the panel to the frame
        frame.setTitle("Crypt The Picture");
        frame.setBounds(100, 100, 800, 400);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        createEvents();

    }

    public static void main(String[] args) {

        GUIComponents GuiComponent = new GUIComponents();

    }


    public static void createEvents() {
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
                    temp = path;
                    System.out.println(temp);

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

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                encImage = new setImage();


                encImage.getEncyptedPicture();

            }
        });

    }

    public static String getPath() {

        return temp;
    }
}