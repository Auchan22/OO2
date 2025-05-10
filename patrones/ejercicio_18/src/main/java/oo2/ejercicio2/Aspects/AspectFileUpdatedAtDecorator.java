package oo2.ejercicio2.Aspects;

import oo2.ejercicio2.FileOO2;

public class AspectFileUpdatedAtDecorator extends AspectDecorator{
    public AspectFileUpdatedAtDecorator(FileOO2 file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint() + this.getFileUpdatedAt();
    }
}
