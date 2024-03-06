package HWPhoneBook;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Set<String>> phoneBook = new HashMap<>();

        // Добавление контактов
        addContact(phoneBook, "Иван Денисов", "89082472211");
        addContact(phoneBook, "Анна Курникова", "89134485562");
        addContact(phoneBook, "Иван Денисов", "89135506666");
        addContact(phoneBook, "Андрей Миронов", "89231442925");
        addContact(phoneBook, "Анна Курникова", "89236602525");
        addContact(phoneBook, "Иван Охлобыстин", "89015550101");
        addContact(phoneBook, "Анна Курникова", "89115550011");

        // Вывод телефонной книги
        System.out.println("Телефонная книга:");
        phoneBook.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    public static void addContact(HashMap<String, Set<String>> phoneBook, String name, String phoneNumber) {
        Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
        phones.add(phoneNumber);
        phoneBook.put(name, phones);
    }
}
