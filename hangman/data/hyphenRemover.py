try:
    with open('russian-nouns.txt', 'r', encoding='utf-8') as file:
        words = file.readlines()

    print(f"Прочитано слов: {len(words)}")
    words = [word.strip() for word in words if '-' not in word]
    print(f"Слов без дефиса: {len(words)}")

    with open('words.txt', 'w', encoding='utf-8') as file:
        file.write('\n'.join(words))
    print("Файл успешно обновлён.")
except FileNotFoundError:
    print("Ошибка: Файл 'words.txt' не найден.")
except PermissionError:
    print("Ошибка: Нет прав на запись в файл 'words.txt'.")
except UnicodeDecodeError:
    print("Ошибка: Проблема с кодировкой файла. Проверьте, что файл в формате UTF-8.")
except Exception as e:
    print(f"Произошла ошибка: {e}")