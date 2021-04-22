package com.thinking.machines.library.bl;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class FileUplodeViewModel extends AbstractTableModel implements FileUploadEventListener
{
private ArrayList<com.thinking.machines.library.bl.FileBean> fileBeans;
private ArrayList<FileUploadThread> fileUploadThreads;
private String title[]={"S.No","File","Status"};

public FileUplodeViewModel()
{
fileBeans=new ArrayList<com.thinking.machines.library.bl.FileBean>();
fileUploadThreads=new ArrayList<FileUploadThread>();
}
public int getColumnCount()
{
return title.length;
}
public String getColumnName(int columnIndex)
{
return title[columnIndex];
}
public int getRowCount()
{
return fileBeans.size();
}
public boolean isCellEditable(int rowIndex,int columnIndex)
{
return false;
}
public Object getValueAt(int rowIndex,int columnIndex)
{
if(columnIndex==0)
{
return rowIndex+1;
}
if(columnIndex==1)
{
return fileBeans.get(rowIndex).getFile();
}
return fileBeans.get(rowIndex).getPercentageUploaded()+"%";
}
public Class getColumnClass(int columnIndex)
{
Class c=null;
try
{
if(columnIndex==0 )
{
c=Class.forName("java.lang.Integer");
}
else
{
c=Class.forName("java.lang.String");
}

}catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe);
}
return c;
}
public void fileUploader()
{
for(FileBean fileBean:fileBeans)
{
FileUploadThread fileUploadThread=new FileUploadThread(fileBean.getFile());
fileUploadThreads.add(fileUploadThread);
fileUploadThread.setFileUploadEventListener(this);
}
for(FileUploadThread fileUploadThread:fileUploadThreads)
{
fileUploadThread.start();
}
}
public void allClear()
{
fileBeans.clear();
fireTableDataChanged();
}
public void fileUploaded(FileUploadEvent fileUploadEvent)
{
}
public void fileUploading(FileUploadEvent fileUploadEvent)
{
}
public void fileUploadTerminated(FileUploadEvent fileUploadEvent)
{
}
public void addFile(File filePath)
{
FileBean fb=new FileBean();
fb.setFile(filePath);
try
{
fileBeans.add(fb);
fireTableDataChanged();
}catch(Exception e)
{
System.out.println(e);
}
}
}