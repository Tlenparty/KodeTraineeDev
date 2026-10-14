# KodeTraineeDev

A take-home assignment for an Android intern position at [KODE](https://kode.ru/):
a company employee directory. The app loads the list of employees
from a mock API, shows it split by department and opens an employee
profile.

## Features

- Employee list with avatar, name and department (RecyclerView + DiffUtil)
- Department tabs on ViewPager2 with custom tabs: all, designers, analysts, managers
- Employee profile: first name, last name, department, birth date, phone number
- Single Activity navigation between screens via Cicerone
- Bottom sheet for choosing the sort order (alphabetical / by birthday) — UI only so far,
  the sorting itself is not implemented

## Tech stack

| Area           | Technologies                                 |
|----------------|----------------------------------------------|
| Language       | Kotlin                                       |
| Architecture   | MVP (Moxy), Repository, Single Activity      |
| Navigation     | Cicerone                                     |
| Concurrency    | RxJava 2                                     |
| Networking     | Retrofit, OkHttp, Gson                       |
| Images         | Glide                                        |
| UI             | ViewBinding (ViewBindingPropertyDelegate), Material Components, ViewPager2 |

## Project structure

```
app/src/main/java/com/tlenparty/kodetraineedev/
├── api/            # Retrofit interface and client factory
├── base_logic/
│   ├── main/       # main screen: search field, tabs, sort bottom sheet
│   ├── users/      # list of all employees and adapter
│   ├── designers/  # department tabs
│   ├── analysts/
│   ├── managers/
│   └── profile/    # employee profile
├── model/          # DTOs and employee repository
└── helpers/        # Cicerone screens, Rx schedulers, network status, extensions
```

## Build

Requires JDK 11–17 and Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
