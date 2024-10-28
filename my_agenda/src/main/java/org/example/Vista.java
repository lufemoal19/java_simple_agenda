package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    JButton saveContact;
    JPanel leftPane, rightPane, contactPane, buttonPane, mainPane, tablePane;
    JTextField nombre, apellido, telefono, email;

    public Vista(String title){
        super(title);
        initProperties();
    }

    public void initProperties(){
        buttonPane = new JPanel(new FlowLayout());
        contactPane = new JPanel(new GridLayout(1,3));

        leftPane = new JPanel(new FlowLayout());
        rightPane = new JPanel(new FlowLayout());

        tablePane = new JPanel();

        mainPane = new JPanel(new BorderLayout());
        mainPane.setBorder(new EmptyBorder(new Insets(50,20,20,20)));

        rightPane.add(tablePane);
        mainPane.add(rightPane, BorderLayout.EAST);
        add(mainPane);

        viewComponents();
        viewProperties();
    }

    public void viewProperties(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,550);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void viewButtons(){
        saveContact = new JButton("Guardar");
        saveContact.setToolTipText("Guardar Contacto");
        saveContact.setActionCommand("0");
        buttonPane.add(saveContact);
    }

    public void viewComponents(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints grid = new GridBagConstraints();

        contactPane.setLayout(layout);
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;

        JLabel label;

        // nombre
        label = new JLabel("Nombre");
        nombre = new JTextField(10);
        contactPane.add(label);
        grid.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(nombre, grid);
        contactPane.add(nombre);

        // apellido
        label = new JLabel("Apellido");
        apellido = new JTextField(10);
        contactPane.add(label);
        grid.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(apellido, grid);
        contactPane.add(apellido);

        // telefono
        label = new JLabel("Telefono");
        telefono = new JTextField(10);
        contactPane.add(label);
        grid.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(telefono, grid);
        contactPane.add(telefono);

        // email
        label = new JLabel("Correo");
        email = new JTextField(10);
        contactPane.add(label);
        grid.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(email, grid);
        contactPane.add(email);

        viewButtons();
        contactPane.add(buttonPane);
        leftPane.add(contactPane);

        mainPane.add(leftPane, BorderLayout.WEST);
    }

    public void addTable(JScrollPane scrollPane){
        if (tablePane.getComponentCount() > 0){
            tablePane.remove(0);
        }
        tablePane.add(scrollPane);
        tablePane.validate();
    }

    public void addActionListener(ActionListener actionListener){
        saveContact.addActionListener(actionListener);
    }

    public void displayErrorMessage(String error){
        JOptionPane.showMessageDialog(this, error,
                "Error!",JOptionPane.ERROR_MESSAGE);
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(this, message,
                "Message!",JOptionPane.INFORMATION_MESSAGE);
    }

    public String getNombre(){
        return nombre.getText();
    }

    public String getApellido(){
        return apellido.getText();
    }

    public String getTelefono(){
        return telefono.getText();
    }

    public String getEmail(){
        return email.getText();
    }

    public void close(){
        this.dispose();
    }
}