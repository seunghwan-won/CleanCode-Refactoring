package cleancode.chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SectionStoreTest {
    private SectionStore sectionStore;
    @BeforeEach
    void setUp() {
        sectionStore = new SectionStore();
    }

    @Test
    void exception() {
        Assertions.assertThrows(StorageException.class, () -> sectionStore.retrieveSection("invalid - file"));
    }
}