package com.thinking.machines.library.bl;

public interface FileUploadEventListener
{
public void fileUploaded(FileUploadEvent fileUploadEvent);
public void fileUploading(FileUploadEvent fileUploadEvent);
public void fileUploadTerminated(FileUploadEvent fileUploadEvent);
}