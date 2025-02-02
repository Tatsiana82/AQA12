package HW_lesson_15;

import org.openqa.selenium.WebElement;

public class Task_3_TwoWeb_Elements {
    public static void compareTwoElements(WebElement element1, WebElement element2) {
        // координаты и размеры элементов

        int element1Top = element1.getLocation().getY();
        int element1Left = element1.getLocation().getX();
        int element1Width = element1.getSize().getWidth();
        int element1Height = element1.getSize().getHeight();
        int element1Area = element1Width * element1Height;

        int element2Top = element2.getLocation().getY();
        int element2Left = element2.getLocation().getX();
        int element2Width = element2.getSize().getWidth();
        int element2Height = element2.getSize().getHeight();
        int element2Area = element2Width * element2Height;

                if (element1Top < element2Top) {
            System.out.println("Элемент 1 располагается выше");
        } else if (element1Top > element2Top) {
            System.out.println("Элемент 2 располагается выше");
        } else {
            System.out.println("Оба элемента располагаются на одной высоте");
        }

         if (element1Left < element2Left) {
            System.out.println("Элемент 1 располагается левее");
        } else if (element1Left > element2Left) {
            System.out.println("Элемент 2 располагается левее");
        } else {
            System.out.println("Оба элемента располагаются на одном уровне по горизонтали");
        }

         if (element1Area > element2Area) {
            System.out.println("Элемент 1 занимает большую площадь");
        } else if (element1Area < element2Area) {
            System.out.println("Элемент 2 занимает большую площадь");
        } else {
            System.out.println("Оба элемента занимают одинаковую площадь");
        }
    }
}