package ee.erm.art.ermmemorygame;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by teras on 24.03.18.
 */

public class MLString {

    public static Language currentLanguage;

    public enum Language {
        Estonian,
        Russian,
        English
    }

    public Map<Language, String> strings;

    public MLString() {
        this.strings = new HashMap<>();
    }

    public String getValue(Language language) {
        return strings.get(language);
    }

    public void setValue(Language language, String text) {
        strings.put(language, text);
    }

    public static Language getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(Language currentLanguage) {
        MLString.currentLanguage = currentLanguage;
    }

    @Override
    public String toString() {
        return "{Estonian: " + strings.get(Language.Estonian) +
                ", Russian: " + strings.get(Language.Russian) +
                ", English: " + strings.get(Language.English) + "}";
    }
}
