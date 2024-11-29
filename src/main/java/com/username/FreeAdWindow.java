package com.username;

import java.util.*;

public class FreeAdWindow extends AnnouncementWindow {

    @Override
    protected Map<String, List<String>> getCategoriesWithSubcategories() {
        // Категорії з підкатегоріями
        Map<String, List<String>> categories = new HashMap<>();
        categories.put("Товари", Arrays.asList("Електроніка", "Одяг", "Дім"));
        categories.put("Послуги", Arrays.asList("Ремонт", "Клінінг", "ІТ"));
        categories.put("Оренда", Arrays.asList("Квартири", "Офіси", "Авто"));
        return categories;
    }

    @Override
    protected List<String> getPersonalDataFields() {
        return Arrays.asList("Ім'я", "Адреса");
    }

    @Override
    protected String getMainInfoPlaceholder() {
        return "Детальний опис";
    }

    @Override
    protected List<String> getContactFields() {
        return Arrays.asList("Телефон", "Email");
    }
}
