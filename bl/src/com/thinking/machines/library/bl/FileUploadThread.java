package com.thinking.machines.library.bl;

import java.net.*;
import java.io.*;
public class FileUploadThread extends Thread 
{
private File file;
private FileUploadEventListener target;
public FileUploadThread(File file)
{
this.file=file;
}
public void setFileUploadEventListener(FileUploadEventListener target)
{
this.target=target;
}
public void run()
{
try
{
String server="Localhost";
int portNumber=6000;
if(file.exists()==false)
{
//problem
return;
}
String fileName=file.getName();
ByteArrayOutputStream baos=new ByteArrayOutputStream();
ObjectOutputStream oos=new ObjectOutputStream(baos);
oos.writeObject(fileName);
byte [] fileNameByteArray;
fileNameByteArray=baos.toByteArray();
int lengthOfFileName=fileNameByteArray.length;
int headerSize=20;
byte header[];
header=new byte[headerSize];
int k=headerSize-1;
long f=lengthOfFileName;
while(k>=0)
{
header[k]=(byte)(f%10);
f=f/10;
k--;
}
Socket socket=new Socket(server,portNumber);
OutputStream os=socket.getOutputStream();
os.write(header,0,headerSize);
os.flush();
byte response[]=new byte[headerSize];
InputStream is=socket.getInputStream();
is.read(response);
int i;
int bufferSize=1024;
int numberOfBytesToWrite=bufferSize;
i=0;
int x=1;
int chunkPercentage=(bufferSize/fileNameByteArray.length)*100;
int percentageUploaded=0;
while(i<fileNameByteArray.length)
{
if(i+bufferSize>fileNameByteArray.length)
{
numberOfBytesToWrite=fileNameByteArray.length-i;
}
os.write(fileNameByteArray,i,numberOfBytesToWrite);
os.flush();
is.read(header);
i=i+bufferSize;
}
long lengthOfFile=file.length();
k=headerSize-1;
f=lengthOfFile;
while(k>=0)
{
header[k]=(byte)(f%10);
f=f/10;
k--;
}
os.write(header,0,headerSize);
os.flush();
is.read(response);
FileInputStream fis=new FileInputStream(file);
BufferedInputStream bis=new BufferedInputStream(fis);
byte contents[]=new byte[1024];
int bytesRead;
i=0;
while(i<lengthOfFile)
{
bytesRead=bis.read(contents);
if(bytesRead<0) break;
os.write(contents,0,bytesRead);
os.flush();
i=i+bytesRead;
}
fis.close();
is.read(response);
socket.close();
}catch(Exception e)
{
//problem
}

}
}