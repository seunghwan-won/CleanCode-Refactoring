package cleancode.chapter7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SectionStore {
    public List<RecordedGrip> retrieveSection(String sectionName) {
        try {
            FileInputStream stream = new FileInputStream(sectionName);
        } catch (FileNotFoundException e) {
            throw new StorageException("retrieval Error", e);
        }
        return new ArrayList<RecordedGrip>();
    }
}
