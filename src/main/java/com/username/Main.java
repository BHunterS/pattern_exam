package com.username;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Харківський Кур'єр ===");
        AnnouncementWindow kharkivWindow = new KharkivCourierWindow();
        kharkivWindow.createWindow();

        System.out.println("\n=== Бесплатка ===");
        AnnouncementWindow freeAdWindow = new FreeAdWindow();
        freeAdWindow.createWindow();
    }
}
