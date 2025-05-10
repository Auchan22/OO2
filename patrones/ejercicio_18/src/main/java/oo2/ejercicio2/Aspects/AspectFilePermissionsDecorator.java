package oo2.ejercicio2.Aspects;

import oo2.ejercicio2.FileOO2;

public class AspectFilePermissionsDecorator extends AspectDecorator{
    public AspectFilePermissionsDecorator(FileOO2 file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint() + this.getPermissions();
    }
}
