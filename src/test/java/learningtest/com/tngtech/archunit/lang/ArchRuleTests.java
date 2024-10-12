package learningtest.com.tngtech.archunit.lang;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

/**
 * Tests for {@link ArchRule}.
 *
 * @author Johnny Lim
 */
class ArchRuleTests {

    @Test
    void noClassesInObjectsPackageShouldCallObjectsRequireNonNull() {
        JavaClasses importedPackages = new ClassFileImporter().importPackages("com.izeye.helloworld.objects");

        ArchRule rule = ArchRuleDefinition.noClasses().should().callMethod(Objects.class, "requireNonNull", Object.class, String.class).because("org.springframework.utils.Assert.notNull(Object, String) should be used instead.");
        assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> rule.check(importedPackages)).withMessageContaining("org.springframework.utils.Assert.notNull(Object, String) should be used instead.");
    }

    @Test
    void noClassesInNoObjectsPackageShouldCallObjectsRequireNonNull() {
        JavaClasses importedPackages = new ClassFileImporter().importPackages("com.izeye.helloworld.noobjects");

        ArchRule rule = ArchRuleDefinition.noClasses().should().callMethod(Objects.class, "requireNonNull", Object.class, String.class).because("org.springframework.utils.Assert.notNull(Object, String) should be used instead.");
        assertThatNoException().isThrownBy(() -> rule.check(importedPackages));
    }

}
