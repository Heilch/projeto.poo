package view;

import javax.swing.*;

import model.BancoUsuarios;
import model.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login - Locadora de Veículos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Color fundo = new Color(28, 40, 51);
        Color destaque = new Color(42, 157, 143);
        Font fonte = new Font("SansSerif", Font.BOLD, 14);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(fundo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(new Color(38, 70, 83));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lblTitulo = new JLabel("Bem-vindo");
        lblTitulo.setForeground(destaque);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(fonte);
        JTextField txtUsuario = new JTextField(15);
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(fonte);
        JPasswordField txtSenha = new JPasswordField(15);
        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBackground(destaque);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(fonte);
        btnLogin.setPreferredSize(new Dimension(120, 30));
        btnLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());
            Usuario user = BancoUsuarios.autenticar(usuario, senha);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Bem-vindo, " + user.getNome() + "!");
                switch (user.getTipo()) {
                case "Administrador":
                	new TelaAdministrador().setVisible(true);
                        break;
                    case "Gerente":
                        new TelaGerente().setVisible(true);
                        break;
                    case "Atendente":
                        new TelaAtendente().setVisible(true);
                        break;
                }
                dispose();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(lblTitulo, gbc);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        card.add(lblUsuario, gbc);
        gbc.gridx = 1;
        card.add(txtUsuario, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        card.add(lblSenha, gbc);
        gbc.gridx = 1;
        card.add(txtSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        card.add(btnLogin, gbc);
        panel.add(card);
        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
