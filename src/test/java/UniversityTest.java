import controller.JsonManager;
import controller.UniversityCreator;
import model.Human;
import model.University;
import model.Sex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {

    @Test
    public void testUniversitySerializationDeserialization() {
        // Створення університету
        UniversityCreator universityCreator = new UniversityCreator();
        Human rector = new Human("Іван", "Петров", "Іванович", Sex.MALE);
        University oldUniversity = universityCreator.createUniversity("Національний Університет", rector);

        // Серіалізація університету в JSON
        String filePath = "university.json";
        JsonManager.saveUniversityToJson(oldUniversity, filePath);

        // Десеріалізація університету з JSON
        University newUniversity = JsonManager.loadUniversityFromJson(filePath);

        // Перевірка на еквівалентність
        assertEquals(oldUniversity, newUniversity);
    }
}