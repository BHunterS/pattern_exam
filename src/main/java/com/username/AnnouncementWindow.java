package com.username;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

abstract class AnnouncementWindow {

    protected Scanner scanner = new Scanner(System.in);
    private String selectedCategory;
    private String selectedSubCategory;
    private Map<String, String> personalData = new HashMap<>();
    private String mainInfo;
    private Map<String, String> contactData = new HashMap<>();

    // Шаблонний метод
    public void createWindow() {
        createCategorySection();
        createPersonalDataSection();
        createMainInfoSection();
        createContactDataSection();
        printAnnouncement();
    }

    // Метод для створення секції "Рубрика" (вибір категорії або підкатегорії)
    protected void createCategorySection() {
        System.out.println("Вибір рубрики:");

        // Отримуємо всі категорії з підкатегоріями
        Map<String, List<String>> categoriesWithSubcategories = getCategoriesWithSubcategories();

        // Перебираємо категорії та виводимо їх
        List<String> categories = new ArrayList<>(categoriesWithSubcategories.keySet());
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }

        System.out.print("Виберіть категорію: ");
        int choice = scanner.nextInt();
        selectedCategory = categories.get(choice - 1);  // Обрана категорія

        // Отримуємо підкатегорії для обраної категорії
        List<String> subCategories = categoriesWithSubcategories.get(selectedCategory);

        if (subCategories != null && !subCategories.isEmpty()) {
            System.out.println("Вибір підкатегорії:");
            // Виводимо підкатегорії
            for (int i = 0; i < subCategories.size(); i++) {
                System.out.println((i + 1) + ". " + subCategories.get(i));
            }
            System.out.print("Виберіть підкатегорію: ");
            choice = scanner.nextInt();
            selectedSubCategory = subCategories.get(choice - 1);  // Обрана підкатегорія
        }
    }


    // Метод для створення секції "Персональні дані" (ввід конкретних полів)
    protected void createPersonalDataSection() {
        System.out.println("Введіть персональні дані:");
        List<String> fields = getPersonalDataFields();
        for (String field : fields) {
            System.out.print(field + ": ");
            String input = scanner.next();
            personalData.put(field, input);
        }
    }

    // Метод для створення секції "Основна інформація" (ввід опису)
    protected void createMainInfoSection() {
        System.out.println("Введіть основну інформацію:");
        String description = getMainInfoPlaceholder();
        System.out.print(description + ": ");
        scanner.nextLine(); // Очистка буфера
        mainInfo = scanner.nextLine();
    }

    // Метод для створення секції "Контактні дані" (ввід конкретних полів)
    protected void createContactDataSection() {
        System.out.println("Введіть контактні дані:");
        List<String> contactFields = getContactFields();
        for (String field : contactFields) {
            System.out.print(field + ": ");
            String input = scanner.next();
            contactData.put(field, input);
        }
    }

    // Метод для форматованого виводу оголошення
    private void printAnnouncement() {
        System.out.println("\n=== Оголошення ===");
        System.out.println("Рубрика: " + selectedCategory);
        if (selectedSubCategory != null) {
            System.out.println("Підкатегорія: " + selectedSubCategory);
        }
        System.out.println("\nПерсональні дані:");
        for (Map.Entry<String, String> entry : personalData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\nОсновна інформація:");
        System.out.println(mainInfo);
        System.out.println("\nКонтактні дані:");
        for (Map.Entry<String, String> entry : contactData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("===================");
    }

    // Абстрактні методи для надання параметрів секцій
    protected abstract Map<String, List<String>> getCategoriesWithSubcategories(); // Список категорій та підкатегорій
    protected abstract List<String> getPersonalDataFields(); // Поля для персональних даних
    protected abstract String getMainInfoPlaceholder(); // Місце для вводу основної інформації
    protected abstract List<String> getContactFields(); // Поля для контактних даних
}
