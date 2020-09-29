package com.example.storageapp.model;

public class LocalFile {

    private String name;
    private String creationTime;
    private String lastmodification;
    private long size;
    private String downloadUri;
    private String deleteUri;
    private String fileType;

    public LocalFile(String name, String creationTime, String lastmodification, long size, String downloadUri, String deleteUri, String fileType) {
        this.name = name;
        this.creationTime = creationTime;
        this.lastmodification = lastmodification;
        this.size = size;
        this.downloadUri = downloadUri;
        this.deleteUri = deleteUri;
        this.fileType = fileType;
    }

    public LocalFile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastmodification() {
        return lastmodification;
    }

    public void setLastmodification(String lastmodification) {
        this.lastmodification = lastmodification;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public String getDeleteUri() {
        return deleteUri;
    }

    public void setDeleteUri(String deleteUri) {
        this.deleteUri = deleteUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
