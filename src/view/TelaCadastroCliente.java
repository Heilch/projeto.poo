package view;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {
    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(28, 40, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titulo = new JLabel("Cadastro de Cliente");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        JLabel lblNome = criarLabel("Nome:");
        JTextField txtNome = new JTextField(15);
        JLabel lblCPF = criarLabel("CPF:");
        JTextField txtCPF = new JTextField(15);
        JLabel lblTelefone = criarLabel("Telefone:");
        JTextField txtTelefone = new JTextField(15);
        
        JButton btnSalvar = criarBotao("Salvar", new Color(42, 157, 143));
        JButton btnCancelar = criarBotao("Cancelar", Color.RED);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        painel.add(lblNome, gbc);
        gbc.gridx = 1;
        painel.add(txtNome, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(lblCPF, gbc);
        gbc.gridx = 1;
        painel.add(txtCPF, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(lblTelefone, gbc);
        gbc.gridx = 1;
        painel.add(txtTelefone, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        painel.add(btnSalvar, gbc);
        
        gbc.gridy = 5;
        painel.add(btnCancelar, gbc);
        
        add(painel);
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
}