# KodeTraineeDev

Тестовое задание на позицию Android-стажёра в компании [KODE](https://kode.ru/):
справочник сотрудников компании. Приложение загружает список сотрудников
с мокового API, показывает его с разбивкой по отделам и открывает профиль
сотрудника.

## Возможности

- Список сотрудников с аватаром, именем и отделом (RecyclerView + DiffUtil)
- Вкладки отделов на ViewPager2 с кастомными табами: все, дизайнеры, аналитики, менеджеры
- Профиль сотрудника: имя, фамилия, отдел, дата рождения, телефон
- Навигация между экранами в Single Activity через Cicerone
- Нижний лист выбора сортировки (по алфавиту / по дню рождения) — пока только интерфейс,
  сама сортировка не реализована

## Стек

| Область        | Технологии                                   |
|----------------|----------------------------------------------|
| Язык           | Kotlin                                       |
| Архитектура    | MVP (Moxy), Repository, Single Activity      |
| Навигация      | Cicerone                                     |
| Асинхронность  | RxJava 2                                     |
| Сеть           | Retrofit, OkHttp, Gson                       |
| Изображения    | Glide                                        |
| UI             | ViewBinding (ViewBindingPropertyDelegate), Material Components, ViewPager2 |

## Структура

```
app/src/main/java/com/tlenparty/kodetraineedev/
├── api/            # Retrofit-интерфейс и фабрика клиента
├── base_logic/
│   ├── main/       # главный экран: поле поиска, вкладки, нижний лист сортировки
│   ├── users/      # список всех сотрудников и адаптер
│   ├── designers/  # вкладки отделов
│   ├── analysts/
│   ├── managers/
│   └── profile/    # профиль сотрудника
├── model/          # DTO и репозиторий сотрудников
└── helpers/        # экраны Cicerone, Rx-планировщики, статус сети, расширения
```

## Сборка

Требуется JDK 11–17 и Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
