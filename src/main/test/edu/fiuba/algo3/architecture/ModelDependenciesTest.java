package edu.fiuba.algo3.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ModelDependenciesTest {
    private final String MODEL = "..modelo..";
    private final String JAVA_LANG = "java..";
    private final String JUNIT = "org.junit..";
    private final String MOCKITO = "org.mockito..";
    private final String JSON = "org.json..";
    private final String CONTROLADOR = "..controlador..";
    private final String IMAGE = "javafx.scene.image..";
    @Test
    public void elModeloSoloPuedeReferenciarClasesDelModeloAdemasJavaAdemasJunit() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("edu.fiuba.algo3.modelo");

        String[] listOfPackages = {MODEL, JAVA_LANG, JUNIT, MOCKITO, JSON, CONTROLADOR, IMAGE};

        ArchRule myRule = classes().that().resideInAPackage(MODEL)
                .should().onlyDependOnClassesThat().resideInAnyPackage(listOfPackages);

        myRule.check(importedClasses);
    }

}
