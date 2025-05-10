package oo2.ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class File implements FileOO2{

    private String fileName;
    private String fileExtension;
    private double fileSize;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String permissions;

    public File(String fileName, String fileExtension, double fileSize, LocalDate createdAt, LocalDate updatedAt, String permissions) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.permissions = permissions;
    }

    @Override
    public String prettyPrint() {
        return "Datos del archivo:\n";
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public String getFileExtension() {
        return this.fileExtension;
    }

    @Override
    public String getFileSize() {
        return this.fileSize + "MB";
    }

    @Override
    public String getFileCreatedAt() {
        return this.createdAt.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    @Override
    public String getFileUpdatedAt() {
        return this.updatedAt.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    @Override
    public String getPermissions() {
        return this.permissions;
    }
}
