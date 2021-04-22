package com.thinking.machines.library.bl;
import java.io.*;
import com.thinking.machines.library.bl.*;
public class FilesUploadEvent
{
private FileUplodeViewModel fileUploadViewModel;
private File [] files;
public FilesUploadEvent(FileUplodeViewModel fileUploadViewModel,File [] files)
{
this.fileUploadViewModel=fileUploadViewModel;
this.files=files;
}

public FileUplodeViewModel getSource()
{
return this.fileUploadViewModel;
}
public File[] getFiles()
{
return this.files;
}
}
