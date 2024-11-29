package com.username;

import java.util.*;

public class KharkivCourierWindow extends AnnouncementWindow {

    @Override
    protected Map<String, List<String>> getCategoriesWithSubcategories() {
        // Категорії без підкатегорій (порожні списки)
        Map<String, List<String>> categories = new HashMap<>();
        categories.put("Нерухомість", Collections.emptyList());
        categories.put("Транспорт", Collections.emptyList());
        categories.put("Робота", Collections.emptyList());
        return categories;
    }

    @Override
    protected List<String> getPersonalDataFields() {
        return Arrays.asList("Ім'я", "Вік");
    }

    @Override
    protected String getMainInfoPlaceholder() {
        return "Короткий опис";
    }

    @Override
    protected List<String> getContactFields() {
        return Arrays.asList("Телефон");
    }
}
