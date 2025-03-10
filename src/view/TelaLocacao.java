package view;

import javax.swing.*;
import java.awt.*;
public class TelaLocacao extends JFrame {
    private JPanel painelPrincipal;
    private JTextField campoCliente, campoVeiculo, campoDataRetirada, campoDataDevolucao, campoValor;
    private JButton btnConfirmar, btnCancelar;
    public TelaLocacao() {
        setTitle("Registrar Locação");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(new Color(28, 40, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("Registrar Locação");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        JLabel lblCliente = criarLabel("Cliente:");
        JLabel lblVeiculo = criarLabel("Veículo:");
        JLabel lblDataRetirada = criarLabel("Data Retirada:");
        JLabel lblDataDevolucao = criarLabel("Data Devolução:");
        JLabel lblValor = criarLabel("Valor:");
        campoCliente = new JTextField(15);
        campoVeiculo = new JTextField(15);
        campoDataRetirada = new JTextField(15);
        campoDataDevolucao = new JTextField(15);
        campoValor = new JTextField(15);
        btnConfirmar = criarBotao("Confirmar", new Color(42, 157, 143));
        btnCancelar = criarBotao("Cancelar", Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        painelPrincipal.add(lblCliente, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoCliente, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(lblVeiculo, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoVeiculo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(lblDataRetirada, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoDataRetirada, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelPrincipal.add(lblDataDevolucao, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoDataDevolucao, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        painelPrincipal.add(lblValor, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoValor, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        painelPrincipal.add(btnConfirmar, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(btnCancelar, gbc);
        add(painelPrincipal);
    }
    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.LIGHT_GRAY);
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
        SwingUtilities.invokeLater(() -> new TelaLocacao().setVisible(true));
    }
}

