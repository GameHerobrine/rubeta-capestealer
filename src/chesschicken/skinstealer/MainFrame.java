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
		setTitle("RuBeta Skin Stealer 0.2 by ChessChicken");
		setBounds(100, 100, 514, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Skin Stealer - \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0430, \u043A\u043E\u0442\u043E\u0440\u0430\u044F \u043F\u043E\u043C\u043E\u0433\u0430\u0435\u0442 \u0432\u0430\u043C \u0443\u043A\u0440\u0430\u0441\u0442\u044C \u0447\u0435\u0439-\u0442\u043E \u0441\u043A\u0438\u043D.");
		lblNewLabel.setBounds(10, 11, 454, 14);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(368, 130, 120, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u041D\u0418\u041A");
		lblNewLabel_1.setBounds(368, 105, 33, 14);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C!");
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
					
					String nickurl = "https://rubeta.xyz/web/MineCraft/MinecraftSkins/" + textField.getText().trim() + ".png";
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
				       
				       scaledImage = image.getScaledInstance(384, 192, Image.SCALE_DEFAULT);   
				       
				       
				       Loadwerf();
				       
				}
			}
		});
		btnNewButton.setBounds(368, 161, 120, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0412\u044B\u0445\u043E\u0434");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(368, 195, 120, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u041F\u0440\u0438 \u0437\u0430\u0433\u0440\u0443\u0437\u043A\u0435 \u0441\u043A\u0438\u043D\u0430, \u043E\u043D \u0441\u043E\u0445\u0440\u0430\u043D\u044F\u0435\u0442\u0441\u044F \u0432\u043E\u0437\u043B\u0435 \u043F\u0440\u043E\u0433\u0438 \u0441 \u0438\u043C\u0435\u043D\u0435\u043C (\u041D\u0418\u041A + png)");
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
