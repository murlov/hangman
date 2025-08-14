# Имя входного и выходного файла
input_file = "russian-nouns.txt"
output_file = "russian-nouns-clean.txt"

# Читаем и фильтруем слова
with open(input_file, "r", encoding="utf-8") as f:
    words = f.readlines()

filtered_words = []
for word in words:
    w = word.strip()
    if len(w) >= 5 and "-" not in w:
        filtered_words.append(w)

# Записываем результат
with open(output_file, "w", encoding="utf-8") as f:
    f.write("\n".join(filtered_words))

print(f"Готово! Отфильтровано {len(filtered_words)} слов, сохранено в {output_file}")
