package com.thinking.machines.library.bl;
import java.io.*;
import com.thinking.machines.library.bl.*;

 public class FileUploadEvent
{
private File file;
private int percentageUploaded;
private FileUploadThread fileUploadThread;
public FileUploadEvent(FileUploadThread fileUploadThread,File file)
{
this.file=file;
this.fileUploadThread=fileUploadThread;
this.percentageUploaded=-1;
}
public FileUploadEvent(FileUploadThread fileUploadThread,File file,int percentageUploaded)
{
this.file=file;
this.fileUploadThread=fileUploadThread;
this.percentageUploaded=percentageUploaded;
}

public File getFile() //konsi file 
{
return this.file;
}
public int getPercentageUploaded()
{
return this.percentageUploaded;
}
public FileUploadThread getSource() //konsa thread ki bat ho rhi 
{
return this.fileUploadThread;
}
}