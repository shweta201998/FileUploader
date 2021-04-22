package com.thinking.machines.library.bl;
import java.io.*;
public class FileBean 
{
private File file;
private int percentageUploaded;
public FileBean()
{
}
public void setFile(File file)
{
this.file=file;
}
public File getFile()
{
return this.file;
}
public void setPersentageUploaded(int persentageUploaded)
{
this.percentageUploaded=percentageUploaded;
}
public int getPercentageUploaded()
{
return this.percentageUploaded;
}
}
