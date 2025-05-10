package oo2.ejercicio2;

import oo2.ejercicio2.Aspects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private FileOO2 file;

    @BeforeEach
    public void setUp() throws Exception {
        this.file = new File("Inmortal", ".mp4", 120, LocalDate.of(2025, 5, 10), LocalDate.of(2025, 6, 11), "777");
    }

    @Test
    public void testOption1(){
        AspectDecorator name = new AspectFileNameDecorator(file);
        AspectDecorator extension = new AspectFileExtensionDecorator(name);

        assertEquals("Datos del archivo:\n Inmortal .mp4", extension.prettyPrint());
    }

    @Test
    public void testOption2(){
        AspectDecorator name = new AspectFileNameDecorator(file);
        AspectDecorator createdAt = new AspectFileCreatedAtDecorator(name);
        AspectDecorator extension = new AspectFileExtensionDecorator(createdAt);

        assertEquals("Datos del archivo:\n Inmortal 20250510 .mp4", extension.prettyPrint());
    }

    @Test
    public void testOption3(){
        AspectDecorator name = new AspectFileNameDecorator(file);
        AspectDecorator size = new AspectFileSizeDecorator(name);
        AspectDecorator permissions = new AspectFilePermissionsDecorator(size);
        AspectDecorator extension = new AspectFileExtensionDecorator(permissions);

        assertEquals("Datos del archivo:\n Inmortal 120.0MB 777 .mp4", extension.prettyPrint());
    }
}
