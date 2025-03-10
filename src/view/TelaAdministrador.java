package view;

import javax.swing.*;
import java.awt.*;
public class TelaAdministrador extends JFrame {
    private JPanel painelPrincipal;
  
    public TelaAdministrador() {
        setTitle("Painel do Administrador");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());
        painelPrincipal.setBackground(new Color(28, 40, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("Painel do Administrador");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        JButton btnCadastrarUsuario = criarBotao("Cadastrar Usuário", new Color(42, 157, 143));
        JButton btnSair = criarBotao("Sair", Color.RED);
       
        btnCadastrarUsuario.addActionListener(e -> abrirTelaCadastroUsuario());
     
        btnSair.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        gbc.gridy = 1;
        painelPrincipal.add(btnCadastrarUsuario, gbc);
        gbc.gridy = 2;
        painelPrincipal.add(btnSair, gbc);
        add(painelPrincipal);
    }
    private void abrirTelaCadastroUsuario() {
        painelPrincipal.removeAll();
        painelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblNome = criarLabel("Nome:");
        JTextField txtNome = new JTextField(15);
        JLabel lblUsuario = criarLabel("Usuário:");
        JTextField txtUsuario = new JTextField(15);
        JLabel lblSenha = criarLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(15);
        JLabel lblCargo = criarLabel("Cargo:");
        String[] cargos = {"Administrador", "Gerente", "Atendente"};
        JComboBox<String> comboCargo = new JComboBox<>(cargos);
        JButton btnSalvar = criarBotao("Salvar Usuário", new Color(42, 157, 143));
        JButton btnVoltar = criarBotao("Voltar", Color.RED);
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());
            String cargo = (String) comboCargo.getSelectedItem();
            if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
            	JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!\n" + "Nome: " + nome + "\nUsuário: " + usuario + "\nCargo: " + cargo);
                txtNome.setText("");
                txtUsuario.setText("");
                txtSenha.setText("");
                comboCargo.setSelectedIndex(0);
            }
        });
        
        btnVoltar.addActionListener(e -> abrirTelaAdministrador());
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelPrincipal.add(lblNome, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(txtNome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(lblUsuario, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(txtUsuario, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(lblSenha, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(txtSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(lblCargo, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(comboCargo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        painelPrincipal.add(btnSalvar, gbc);
        gbc.gridy = 5;
        painelPrincipal.add(btnVoltar, gbc);
        painelPrincipal.revalidate();
        painelPrincipal.repaint();
    }
    private void abrirTelaAdministrador() {
        painelPrincipal.removeAll();
        painelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("Painel do Administrador");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        JButton btnCadastrarUsuario = criarBotao("Cadastrar Usuário", new Color(42, 157, 143));
        JButton btnSair = criarBotao("Sair", Color.RED);
        btnCadastrarUsuario.addActionListener(e -> abrirTelaCadastroUsuario());
        btnSair.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        gbc.gridy = 1;
        painelPrincipal.add(btnCadastrarUsuario, gbc);
        gbc.gridy = 2;
        painelPrincipal.add(btnSair, gbc);
        painelPrincipal.revalidate();
        painelPrincipal.repaint();
    } 
    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        return label;
    }
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.BLACK);
        botao.setFont(new Font("SansSerif", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setPreferredSize(new Dimension(200, 35));
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	botao.setBackground(cor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	botao.setBackground(cor);
            }
        });
       return botao;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaAdministrador().setVisible(true);
        });
    }
}

