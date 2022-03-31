package chesschicken.skinstealer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class MainFrame extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	JLabel lwi = new JLabel();
	
	public static BufferedImage image = null;
	private Image scaledImage = null;

	/**
	 * Launch the application.
	 */
	public static void runme()
	{
		try
		{
			MainFrame dialog = new MainFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			FrameError.callerror(e.toString());
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/chesschicken/skinstealer/Icon.png")));
		setTitle("RuBeta Cape Stealer 0.1 by GameHerobrine");
		setBounds(100, 100, 514, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CapeStealer is a program to help you to steal cape ^-^");
		lblNewLabel.setBounds(10, 11, 454, 14);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(368, 130, 120, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname");
		lblNewLabel_1.setBounds(368, 105, 60, 14);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Steal =)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText() != null)
				{
					contentPanel.remove(lwi);
					image = null;
					scaledImage = null;
					String newfile = textField.getText().trim();
					File meme = new File(newfile + ".png");
					if(meme.exists())
					{
						meme.delete();
					}
					File file1 = new File(newfile + ".png");
					try
					{
						file1.createNewFile();
					}catch (IOException e1)
					{
						FrameError.callerror(e1.toString());
					}
					
					String nickurl = "http://assets.rubeta.net/cloaks/" + textField.getText().trim() + ".png";
					try (BufferedInputStream in = new BufferedInputStream(new URL(nickurl).openStream());
							  FileOutputStream fileOutputStream = new FileOutputStream(newfile + ".png"))
					{
							    byte dataBuffer[] = new byte[1024];
							    int bytesRead;
							    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
							        fileOutputStream.write(dataBuffer, 0, bytesRead);
							    }
							    
							} catch (IOException e2)
					{
							    FrameError.callerror(e2.toString());
							    
							}
					
				       try
				       {                
				           image = ImageIO.read(new File(newfile + ".png"));
				        } catch (IOException ex)
				       {
				        	FrameError.callerror(ex.toString());
				        }
				       
				       scaledImage = image.getScaledInstance(22*6, 17*6, Image.SCALE_DEFAULT);   
				       
				       
				       Loadwerf();
				       
				}
			}
		});
		btnNewButton.setBounds(368, 161, 120, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit =(");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(368, 195, 120, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stolen cape location: <CAPESTEALER>/<NICKNAME>.png");
		lblNewLabel_2.setBounds(10, 39, 478, 14);
		contentPanel.add(lblNewLabel_2);
	}
	public void Loadwerf()
	{
	       lwi.setLayout(null);
	       lwi.setBounds(10, 36, 384, 192);
	       lwi.setIcon(new ImageIcon(scaledImage));
	       contentPanel.updateUI();
	       contentPanel.add(lwi);
	}

}
