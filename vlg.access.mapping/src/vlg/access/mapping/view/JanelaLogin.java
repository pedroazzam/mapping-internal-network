package vlg.access.mapping.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vlg.access.mapping.model.Login;
import vlg.access.mapping.model.LoginDAO;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JButton btnSair;
	private JButton btnEntrar;
	private JLabel lblIMG;
	private JLabel lblMensagem;

	String imgCon = "/Connection48.png";
	String msgCon = "Conectando ao Banco de Dados...";
	CaixaMensagem caixaConexao = new CaixaMensagem(imgCon, msgCon);
	private JPasswordField psfSenha;

	private String usuarioLogado;

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin frame = new JanelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("ERROU EM: " + e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaLogin() {
		setResizable(false);
		setTitle("Mapeamento / Login...");
		Image imgLogin16 = new ImageIcon(this.getClass().getResource("/Login16.png")).getImage();
		setIconImage(imgLogin16);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 293);
		contentPane = new JPanel();

		Color backLogo = new Color(24, 22, 23);
		contentPane.setBackground(backLogo);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPorFavorInsira = new JLabel("Por favor insira as suas credenciais");
		lblPorFavorInsira.setForeground(Color.WHITE);
		lblPorFavorInsira.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblbLogin = new JLabel("Login");
		lblbLogin.setForeground(Color.WHITE);
		lblbLogin.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		btnEntrar = new JButton("Mapear");
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnEntrar.setBackground(Color.WHITE);
		Image imgNetwork48 = new ImageIcon(this.getClass().getResource("/network48.png")).getImage();
		btnEntrar.setIcon(new ImageIcon(imgNetwork48));

		btnSair = new JButton("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnSair.setBackground(Color.WHITE);
		Image imgSair48 = new ImageIcon(this.getClass().getResource("/Sair48.png")).getImage();
		btnSair.setIcon(new ImageIcon(imgSair48));
		Image imgQuestion16 = new ImageIcon(this.getClass().getResource("/Question16.png")).getImage();

		lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 9));

		psfSenha = new JPasswordField();

		lblIMG = new JLabel("");
		JLabel lblIMG2 = new JLabel("");
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG2.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgVLG_logo_130 = new ImageIcon(this.getClass().getResource("/VLG_logoNewMapeamento_130.png")).getImage();

		lblIMG.setIcon(new ImageIcon(imgNetwork48));
		lblIMG2.setIcon(new ImageIcon(imgVLG_logo_130));

		JSeparator separator = new JSeparator();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addComponent(lblIMG2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblIMG).addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPorFavorInsira, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblbLogin, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtLogin,
														GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(psfSenha,
														GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
						.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addComponent(btnEntrar)
								.addGap(80)
								.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGap(119)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblIMG2)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPorFavorInsira).addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblbLogin)
										.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSenha)
										.addComponent(psfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblIMG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnEntrar)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(23, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		CreateEvents();
	}

	public void AvisoConexaoInserir() {
		caixaConexao.setVisible(true);
	}

	public void AvisoConexaoRetirar() {
		caixaConexao.setVisible(false);
	}

	public void VerificarChave() {
		lblMensagem.setText("");

		try {
			AvisoConexaoInserir();
			String lg = txtLogin.getText();
			Login login = new Login();
			LoginDAO logindao = new LoginDAO();
			logindao.setUsuarioLogadoDAOS(lg);

			login = logindao.selecionarPorLogin(lg);// --------------------------------------------------OK

			if (login.getSenha() != null) {

				if (login.getSenha().equals(psfSenha.getText())) {

					Main main = new Main(login.getLogin());

					// main.setTitle("Fatorial Investimentos // Logado como
					// " + lg);
					// main.setUser(lg);
					// main.setUserRights(login.getDireito());

					main.setVisible(true);
					AvisoConexaoRetirar();
					dispose();

				} else {
					String msg = "Dados de login e/ou senha incorretos!";
					lblMensagem.setText(msg);
					AvisoConexaoRetirar();
				}
			} else {
				String msg = "Dados de login e/ou senha incorretos!";
				lblMensagem.setText(msg);
				AvisoConexaoRetirar();
			}

		} catch (Exception e) {
			String msg = "Dados de login e/ou senha incorretos!";
			lblMensagem.setText(msg);
			AvisoConexaoRetirar();
		}
	}

	// SOLUÇÃO PARA ENTRAR AO PRESSIONAR O ENTER!--------------------
	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent evt) {
			if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
				btnEntrar.doClick();
			}
		}
	}
	// -------------------------------------------------------------

	private void CreateEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarChave();// REATIVAR QUANDO NAO ESTIVER EM MODO TESTE!!!

				// Main main = new Main("user", "adm");//SOMENTE EM MODO TESTE!!!
				// main.setVisible(true);//SOMENTE EM MODO TESTE!!!
				// dispose();//SOMENTE EM MODO TESTE!!!

			}
		});

		// BLOCO ABAIXO É PARA CHAMAR A CLASSE PARA APERTAR O BOTÃO ENTRAR AO PRESSIONAR
		// A TECLA ENTER!
		btnEntrar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		txtLogin.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		psfSenha.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});

	}
}
