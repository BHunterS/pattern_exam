package com.username;

import java.util.*;

abstract class AnnouncementWindow {

    protected Scanner scanner = new Scanner(System.in);

    // Шаблонний метод
    public void createWindow() {
        createCategorySection();
        createPersonalDataSection();
        createMainInfoSection();
        createContactDataSection();
    }

    // Метод для створення секції "Рубрика" з підтримкою підкатегорій
    protected void createCategorySection() {
        System.out.println("Вибір рубрики:");
        Map<String, List<String>> categories = getCategoriesWithSubcategories();
        List<String> mainCategories = new ArrayList<>(categories.keySet());

        for (int i = 0; i < mainCategories.size(); i++) {
            System.out.println((i + 1) + ". " + mainCategories.get(i));
        }

        System.out.print("Виберіть категорію: ");
        int choice = scanner.nextInt();
        String selectedCategory = mainCategories.get(choice - 1);
        System.out.println("Обрана категорія: " + selectedCategory);

        // Обробка підкатегорій, якщо вони є
        List<String> subcategories = categories.get(selectedCategory);
        if (subcategories != null && !subcategories.isEmpty()) {
            System.out.println("Підкатегорії:");
            for (int i = 0; i < subcategories.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + subcategories.get(i));
            }
            System.out.print("Виберіть підкатегорію: ");
            int subChoice = scanner.nextInt();
            System.out.println("Обрана підкатегорія: " + subcategories.get(subChoice - 1));
        }
    }

    // Метод для створення секції "Персональні дані"
    protected void createPersonalDataSection() {
        System.out.println("Введіть персональні дані:");
        List<String> fields = getPersonalDataFields();
        for (String field : fields) {
            System.out.print(field + ": ");
            String input = scanner.next();
            System.out.println(field + " - " + input);
        }
    }

    // Метод для створення секції "Основна інформація"
    protected void createMainInfoSection() {
        System.out.println("Введіть основну інформацію:");
        String description = getMainInfoPlaceholder();
        System.out.print(description + ": ");
        String input = scanner.next();
        System.out.println("Основна інформація: " + input);
    }

    // Метод для створення секції "Контактні дані"
    protected void createContactDataSection() {
        System.out.println("Введіть контактні дані:");
        List<String> contactFields = getContactFields();
        for (String field : contactFields) {
            System.out.print(field + ": ");
            String input = scanner.next();
            System.out.println(field + " - " + input);
        }
    }

    // Абстрактні методи для надання параметрів секцій
    protected abstract Map<String, List<String>> getCategoriesWithSubcategories(); // Категорії з підкатегоріями
    protected abstract List<String> getPersonalDataFields(); // Поля для персональних даних
    protected abstract String getMainInfoPlaceholder(); // Місце для вводу основної інформації
    protected abstract List<String> getContactFields(); // Поля для контактних даних
}
