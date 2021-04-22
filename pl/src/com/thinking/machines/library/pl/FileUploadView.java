package com.thinking.machines.library.pl;
import com.thinking.machines.library.bl.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
public class FileUploadView extends JFrame implements ActionListener
{
private Container c;
private JTable table;
private JScrollPane jsp;
private FileUplodeViewModel fileUploadViewModel;
private JButton addFileButton;
private JButton uploadFileButton;
private JLabel moduleTitleLabel;
private JButton clearButton;
public FileUploadView()
{
 super("File Sender");
initComponants();
addListener();
setAppearance();
}
public void initComponants()
{
clearButton=new JButton("C");
moduleTitleLabel=new JLabel("File Sender");
addFileButton=new JButton("A");
uploadFileButton=new JButton("U");
fileUploadViewModel=new FileUplodeViewModel();
table=new JTable(fileUploadViewModel);
}
public void setAppearance()
{
Font font=new Font("Arial",Font.BOLD,20);
table.getTableHeader().setFont(font);
Font titleFont=new Font("Verdana",Font.BOLD,25);
Font f=new Font("Verdana",Font.PLAIN,16);
moduleTitleLabel.setFont(titleFont);
table.setFont(f);
table.setRowHeight(30);
TableColumnModel columnModel=table.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(30);
table.getColumnModel().getColumn(1).setPreferredWidth(530);
table.getColumnModel().getColumn(2).setPreferredWidth(40);

jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
c=getContentPane();
int lm=5,tm=5;
moduleTitleLabel.setBounds(lm,tm,200,40);
jsp.setBounds(lm,40+tm,970,450);
addFileButton.setBounds(lm+370,tm+455+40,50,50);
uploadFileButton.setBounds(lm+370+60,tm+455+40,50,50);
clearButton.setBounds(lm+370+60+60,tm+455+40,50,50);
c.add(addFileButton);
c.add(uploadFileButton);
c.add(jsp);
c.add(moduleTitleLabel);
c.add(clearButton);
setLayout(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(1000,600);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

setLocation(d.width-1200,d.height-800);
setVisible(true);
}
public void addListener()
{
addFileButton.addActionListener(this);
uploadFileButton.addActionListener(this);
clearButton.addActionListener(this);
}
public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==addFileButton)
{
JFileChooser jfc=new JFileChooser();
int returnValue=jfc.showOpenDialog(FileUploadView.this);
if(returnValue==JFileChooser.APPROVE_OPTION)
{

File selectedFile=jfc.getSelectedFile();
if(selectedFile.exists()==false)
{
JOptionPane.showMessageDialog(FileUploadView.this,"File Not existes");
return;
}
if(selectedFile.isDirectory())
{
JOptionPane.showMessageDialog(FileUploadView.this,"File Not existes");
return;

}
fileUploadViewModel.addFile(selectedFile);
}
}
if(ev.getSource()==uploadFileButton)
{

}
if(ev.getSource()==clearButton)
{
int selectedOption=JOptionPane.showConfirmDialog(FileUploadView.this,"Upload Files ?","file",JOptionPane.YES_NO_OPTION);
if(selectedOption==JOptionPane.YES_OPTION) 
{
fileUploadViewModel.allClear();

}
else
{
return;
}
}
}
}