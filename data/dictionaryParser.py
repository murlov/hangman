import re

with open('dictionary.sql', 'r', encoding='utf-8') as file:
    sql_content = file.read()

pattern = r"\(\d+, '([^']{6,})'"
words = re.findall(pattern, sql_content)

with open('words.txt', 'w', encoding='utf-8') as output_file:
    for word in words:
        output_file.write(word + '\n')

print(f"Сохранено {len(words)} слов в файл words.txt")
