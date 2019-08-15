package vlg.access.mapping.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vlg.access.mapping.model.DriverNetwork;
import vlg.access.mapping.model.DriverNetworkDAO;
import vlg.access.mapping.model.Login;
import vlg.access.mapping.model.LoginDAO;
import vlg.access.mapping.model.Mapping;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private JButton btnMapear;
	private JButton btnDesmapear;
	private JLabel lblIMG2;
	private JLabel lblIMG;
	private JSeparator separator;
	private JLabel lblUser;

	List<Login> acesso;
	List<DriverNetwork> drivers;
	private JButton btnModificarSenha;
	private JPasswordField pwdNovaSenha;
	private JLabel lblNovaSenha;
	private JButton btnAlterar;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(user);
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
	public Main(String user) {
		setResizable(false);
		setTitle("Mapeamento de Rede - VLG Investimentos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				//unmapExample();
				unMap();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				//mapExample();
				map(user);
			}
		});

		initComponents(user);
		createEvents(user);
	}

	public void initComponents(String user) {

		Image imgNetwork48 = new ImageIcon(this.getClass().getResource("/network48.png")).getImage();
		setIconImage(imgNetwork48);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 386);
		contentPane = new JPanel();

		Color backLogo = new Color(24, 22, 23);
		contentPane.setBackground(backLogo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnMapear = new JButton("Mapear");
		btnMapear.setVisible(false);

		btnDesmapear = new JButton("Desmapear");
		btnDesmapear.setVisible(false);

		lblIMG = new JLabel("");
		JLabel lblIMG2 = new JLabel("");
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG2.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgVLG_logo_130 = new ImageIcon(this.getClass().getResource("/VLG_logoNewMapeamento_130.png")).getImage();

		lblIMG.setIcon(new ImageIcon(imgNetwork48));
		lblIMG2.setIcon(new ImageIcon(imgVLG_logo_130));

		separator = new JSeparator();

		lblUser = new JLabel("Usu\u00E1rio: " + user);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		btnModificarSenha = new JButton("Modificar Senha");
		
		Image imgChangePassword16 = new ImageIcon(this.getClass().getResource("/change-password16.png")).getImage();
		btnModificarSenha.setIcon(new ImageIcon(imgChangePassword16));
		
		lblNovaSenha = new JLabel("Digite a nova senha.");
		lblNovaSenha.setVisible(false);
		lblNovaSenha.setForeground(Color.WHITE);
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		pwdNovaSenha = new JPasswordField();
		pwdNovaSenha.setVisible(false);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setVisible(false);
		
		Image imgAlterarSenha16 = new ImageIcon(this.getClass().getResource("/alterarSenha16.png")).getImage();
		btnAlterar.setIcon(new ImageIcon(imgAlterarSenha16));
		
		scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIMG2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblIMG, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pwdNovaSenha, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNovaSenha, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnModificarSenha, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMapear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDesmapear))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIMG2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIMG, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUser)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificarSenha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNovaSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pwdNovaSenha, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)))
					.addGap(20)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMapear, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDesmapear, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(344))
		);
		
				textPane = new JTextPane();
				textPane.setBackground(Color.LIGHT_GRAY);
				scrollPane.setViewportView(textPane);
				textPane.setEditable(false);
		contentPane.setLayout(gl_contentPane);

	}

	public void mapExample() {
		textPane.setText("Mapeando network VLG...");

		String user = "PedroAzzam";
		String password = "VLG123";
		String letter = "";
		String name = "";
		Mapping mapping = new Mapping();

		name = "Alocacao";
		letter = "G";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Financeiro";
		letter = "H";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Gerencial";
		letter = "I";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Renda_Variavel";
		letter = "J";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Temp_Todos";
		letter = "K";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Tesouraria";
		letter = "L";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Tecnologia";
		letter = "M";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Compliance";
		letter = "N";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		name = "Administrativo";
		letter = "O";
		mapping.map(letter, name, user, password);
		mapping.rename(letter, name);

		textPane.setText(textPane.getText() + "\n"
				+ " Mapeamento finalizado! \n Para permanecer com a rede mapeada neste computador, basta manter este programa aberto (podendo minimizá-lo).");
	}

	public void unmapExample() {
		String letter = "";
		String name = "";
		Mapping mapping = new Mapping();

		letter = "G";
		mapping.unmap(letter);

		letter = "H";
		mapping.unmap(letter);

		letter = "I";
		mapping.unmap(letter);

		letter = "J";
		mapping.unmap(letter);

		letter = "K";
		mapping.unmap(letter);

		letter = "L";
		mapping.unmap(letter);

		letter = "M";
		mapping.unmap(letter);

		letter = "N";
		mapping.unmap(letter);

		letter = "O";
		mapping.unmap(letter);
	}

	public void mapOld(String user) {
		
		System.out.println("check01");
		
		textPane.setText("Mapeando network VLG...");
		
		LoginDAO logindao = new LoginDAO();
		acesso = logindao.selecionarPorUser(user);
		
		System.out.println("check02");
		
		String userNetwork = acesso.get(0).getUser_Network();//buscar o usernetwork deste user
		String senhaNetwork = acesso.get(0).getSenha_Network();//buscar a senhanetwork deste user
		String letter = "";//Buscar a lista de letras da table deste user
		String name = "";//buscar a lista de nomes das letras da table deste user
		
		Mapping mapping = new Mapping();
		
		DriverNetworkDAO drivernetworkdao = new DriverNetworkDAO();
		drivers = drivernetworkdao.selecionarDriversPorUserTable("user_" + user);
		
		System.out.println("check03");
		
		for (int i=0;i<drivers.size();i++) {
			mapping.map(drivers.get(i).getLetra(), drivers.get(i).getNome(), userNetwork, senhaNetwork);
			mapping.rename(drivers.get(i).getLetra(), drivers.get(i).getNome());
		}
		textPane.setText(textPane.getText() + "\n"
				+ " Mapeamento finalizado! \n Para permanecer com a rede mapeada neste computador, basta manter este programa aberto (podendo minimizá-lo).");
		
	}
	
public void map(String user) {
		
		System.out.println("check01");
		
		textPane.setText("Mapeando network VLG...");
		
		LoginDAO logindao = new LoginDAO();
		acesso = logindao.selecionarPorUser(user);
		
		System.out.println("check02");
		
		String userNetwork = acesso.get(0).getUser_Network();//buscar o usernetwork deste user
		String senhaNetwork = acesso.get(0).getSenha_Network();//buscar a senhanetwork deste user
		String letter = "";//Buscar a lista de letras da table deste user
		String name = "";//buscar a lista de nomes das letras da table deste user
		
		Mapping mapping = new Mapping();
		
		DriverNetworkDAO drivernetworkdao = new DriverNetworkDAO();
		drivers = drivernetworkdao.selecionarDrivers();
		
		System.out.println("check03");
		
		for (int i=0;i<drivers.size();i++) {
			System.out.println("Mapeando o driver " + drivers.get(i).getLetra() + ": " + drivers.get(i).getNome());
			
			mapping.map(drivers.get(i).getLetra(), drivers.get(i).getNome(), userNetwork, senhaNetwork);
			mapping.rename(drivers.get(i).getLetra(), drivers.get(i).getNome());
		}
		textPane.setText(textPane.getText() + "\n"
				+ " Mapeamento finalizado! \n Para permanecer com a rede mapeada neste computador, basta manter este programa aberto (podendo minimizá-lo).");
		
	}

	public void unMap() {
		Mapping mapping = new Mapping();
		
		for (int i=0;i<drivers.size();i++) {
			mapping.unmap(drivers.get(i).getLetra());
		}

	}

	public void createEvents(String user) {

		
		btnModificarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (pwdNovaSenha.isVisible()) {
					//caso seja visible, irei alterar a senha!
					lblNovaSenha.setVisible(false);
					//lblNovaSenha.setText("Digite a nova senha.");
					
					pwdNovaSenha.setVisible(false);
					btnAlterar.setVisible(false);
				}else {
					//Caso não seja visible, tenho que deixá-lo visible!
					lblNovaSenha.setVisible(true);
					lblNovaSenha.setText("Digite a nova senha.");
					
					pwdNovaSenha.setVisible(true);
					btnAlterar.setVisible(true);
				}
				
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pwdNovaSenha.getText().isEmpty()) {
					
				}else {
					//ALTERAR A SENHA
					LoginDAO logindao = new LoginDAO();
					String retorno = logindao.MudarSenhaAcesso(user, pwdNovaSenha.getText());
					if (retorno=="OK") {
						textPane.setText(textPane.getText() + "\n" + "Senha alterada com sucesso!");
						lblNovaSenha.setVisible(false);
						pwdNovaSenha.setVisible(false);
						btnAlterar.setVisible(false);
					}else {
						textPane.setText(textPane.getText() + "\n" + "Não foi possível alterar a senha...\n" + retorno);
					}
				}
				
			}
		});
		
		
		
		btnMapear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mapExample();
			}
		});

		btnDesmapear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unmapExample();
			}
		});

	}
}
