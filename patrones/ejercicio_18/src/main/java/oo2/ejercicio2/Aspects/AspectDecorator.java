package oo2.ejercicio2.Aspects;

import oo2.ejercicio2.File;
import oo2.ejercicio2.FileOO2;

public abstract class AspectDecorator implements FileOO2 {

    private FileOO2 wrapee;

    public AspectDecorator(FileOO2 file) {
        this.wrapee = file;
    }

    @Override
    public String prettyPrint() {
        return this.wrapee.prettyPrint() + " ";
    }

    @Override
    public String getFileName() {
        return this.wrapee.getFileName();
    }

    @Override
    public String getFileExtension() {
        return this.wrapee.getFileExtension();
    }

    @Override
    public String getFileSize() {
        return this.wrapee.getFileSize();
    }

    @Override
    public String getFileCreatedAt() {
        return this.wrapee.getFileCreatedAt();
    }

    @Override
    public String getFileUpdatedAt() {
        return this.wrapee.getFileUpdatedAt();
    }

    @Override
    public String getPermissions() {
        return this.wrapee.getPermissions();
    }
}
