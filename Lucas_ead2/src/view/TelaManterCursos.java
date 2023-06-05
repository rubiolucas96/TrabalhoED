package view;

import controller.CursosController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaManterCursos extends JFrame {
	
	private static final long serialVersionUID = 6909508245638580811L;
	private JPanel contentPane;
	private JTextField txtSistemaDeOrientacao;
	private JTextField txtPropriedadeDaFatec_1;
	private JTextField tfNome;	
	private JTextField tfID;
	private JTable table;



//====================================================================================================================================
//============================================================ TELA BASE =============================================================
//====================================================================================================================================
	public TelaManterCursos() {
		setBackground(new Color(214, 220, 228));
		
		setTitle("Gerenciamento de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1024, 680);// TAMANHO DA TELA
		contentPane = new JPanel();

		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----------------------------------------------------------------------------------------------------------------------------
		JLabel LOGO = new JLabel("");
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setBackground(Color.BLACK);
		LOGO.setIcon(new ImageIcon("C:\\TEMP\\logo.png"));
		LOGO.setBounds(0, 0, 207, 93);
		contentPane.add(LOGO);
		
		//----------------------------------------------------------------------------------------------------------------------------
		txtSistemaDeOrientacao = new JTextField();
		txtSistemaDeOrientacao.setEditable(false);
		txtSistemaDeOrientacao.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSistemaDeOrientacao.setForeground(Color.WHITE);
		txtSistemaDeOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtSistemaDeOrientacao.setText("Gerenciamento de TCC                     ");
		txtSistemaDeOrientacao.setBackground(Color.BLACK);
		txtSistemaDeOrientacao.setBounds(0, 0, 1008, 93);
		contentPane.add(txtSistemaDeOrientacao);
		txtSistemaDeOrientacao.setColumns(10);
		
		txtPropriedadeDaFatec_1 = new JTextField();
		txtPropriedadeDaFatec_1.setText("Propriedade da FATEC Zona Leste. Todos os direitos reservados ®");
		txtPropriedadeDaFatec_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPropriedadeDaFatec_1.setForeground(Color.WHITE);
		txtPropriedadeDaFatec_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPropriedadeDaFatec_1.setEditable(false);
		txtPropriedadeDaFatec_1.setColumns(10);
		txtPropriedadeDaFatec_1.setBackground(Color.BLACK);
		txtPropriedadeDaFatec_1.setBounds(0, 616, 1008, 25);
		contentPane.add(txtPropriedadeDaFatec_1);
		
		
		tfNome = new JTextField();
		tfNome.setToolTipText("Informe a descrição do Tema do TCC");
		tfNome.setBounds(211, 160, 398, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Tema do TCC");
		lblNome.setBounds(211, 144, 80, 17);
		lblNome.setForeground(Color.WHITE);
		contentPane.add(lblNome);
		
		
		JLabel lblDescrio = new JLabel("Procura");
		lblDescrio.setBounds(68, 201, 110, 17);
		lblDescrio.setForeground(Color.WHITE);
		contentPane.add(lblDescrio);
		
		JLabel lblInserindoCursos = new JLabel("Inserindo Tema do TCC");
		lblInserindoCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserindoCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserindoCursos.setForeground(Color.WHITE);
		lblInserindoCursos.setBounds(58, 108, 907, 17);
		
		contentPane.add(lblInserindoCursos);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(310, 500, 110, 32);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(465, 500, 110, 32);
		contentPane.add(btnExcluir);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(620, 500, 110, 32);
		contentPane.add(btnGravar);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("C:\\TEMP\\lupa.png"));
		btnPesquisar.setActionCommand("pesquisar");
		btnPesquisar.setBounds(619, 148, 32, 32);
		contentPane.add(btnPesquisar);
//		150,500, 110, 32


		
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(68, 160, 90, 20);
		contentPane.add(tfID);
		
		JLabel lbID = new JLabel("ID");
		lbID.setForeground(Color.WHITE);
		lbID.setBounds(68, 144, 110, 17);
		contentPane.add(lbID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(68, 216, 725, 196);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		table = new JTable();
		table.setBounds(104, 493, 74, -23);
		contentPane.add(table);
		
		
		//----------------------------------------------------------------------------------------------------------------------------
		

		CursosController cursoCTR = new CursosController(tfID, tfNome, taLista);
		
		JButton btnFechar = new JButton("Fechar Janela");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(125,500, 134, 32);
		contentPane.add(btnFechar);
		
		btnGravar.addActionListener(cursoCTR);
		btnAlterar.addActionListener(cursoCTR);
		btnExcluir.addActionListener(cursoCTR);
		btnPesquisar.addActionListener(cursoCTR);
		
	}
}	