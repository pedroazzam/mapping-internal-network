package vlg.access.mapping.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class CaixaMensagem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblMensagem;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblImg;
	private static String permissao;

	public static String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		CaixaMensagem.permissao = permissao;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String img, String msg) {
		try {
			CaixaMensagem dialog = new CaixaMensagem(img, msg);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CaixaMensagem(String img, String msg) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPermissao(null);
		
		setTitle("Mensagem...");
		Image imgMessage = new ImageIcon(this.getClass().getResource("/message16.png")).getImage();
		setIconImage(imgMessage);
		setBounds(100, 100, 440, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblMensagem = new JLabel("...");
		lblImg = new JLabel("");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(3)
					.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMensagem)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMensagem))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Image imgOk16 = new ImageIcon(this.getClass().getResource("/Ok16.png")).getImage();
				okButton.setIcon(new ImageIcon(imgOk16));
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Image imgCancel16 = new ImageIcon(this.getClass().getResource("/Cancel16.png")).getImage();
				cancelButton.setIcon(new ImageIcon(imgCancel16));

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				//CASO SEJA UMA MENSAGEM INFORMATIVA DE LOGADO NO XPCONNECT, TIRAR O BOTAO CANCELAR
				if (msg=="Logado ao XP Connect com sucesso!"){
					cancelButton.setVisible(false);
				}
				
			}
		}
		//Modelar a mensagem
		lblMensagem.setText(msg);
		Image imgDisplay = new ImageIcon(this.getClass().getResource(img)).getImage();
		lblImg.setIcon(new ImageIcon(imgDisplay));
		
		//System.out.println(img + "-------------------------------------");
		if (img.equals("/ok48.png")){
			cancelButton.setVisible(false);
		}
		if (img.equals("/Connection48.png")){
			setModal(false);
			setTitle(msg);
			Image imgMessageCon = new ImageIcon(this.getClass().getResource("/Connection48.png")).getImage();
			setIconImage(imgMessageCon);
			
			cancelButton.setVisible(false);
			okButton.setVisible(false);
		}
		if (img.equals("/Trash48.png")){
			cancelButton.setVisible(false);
		}
		if (img.equals("/Edit32.png")){
			cancelButton.setVisible(false);
		}
		CreateEvents();
	}
	
	
	public void CreateEvents(){
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPermissao("ok");
				dispose();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPermissao("cancelar");
				dispose();
			}
		});
		
	}	
}
