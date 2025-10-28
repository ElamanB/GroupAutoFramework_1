🧩 Рекомендуемая структура проекта

GroupAutoFramework/
│
├── pom.xml
├── .gitignore
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── core/                   # общие вещи (driver, hooks, base classes)
│   │   │   ├── config/                 # чтение properties, env variables
│   │   │   ├── api/                    # API utilities (RestAssured, payloads)
│   │   │   ├── ui/                     # WebDriver, PageFactory, BasePage
│   │   │   └── reporting/              # ExtentManager, Cucumber hooks
│   │   └── resources/
│   │       ├── extent.properties
│   │       ├── extent-config.xml
│   │       └── configurations.properties
│   │
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   ├── siteA/
│       │   │   │   ├── UISiteARunner.java
│       │   │   │   └── APISiteARunner.java
│       │   │   ├── siteB/
│       │   │   │   ├── UISiteBRunner.java
│       │   │   │   └── APISiteBRunner.java
│       │   │   └── common/
│       │   │       └── RegressionRunner.java
│       │   │
│       │   ├── steps/
│       │   │   ├── siteA/
│       │   │   │   ├── ui/
│       │   │   │   └── api/
│       │   │   ├── siteB/
│       │   │   │   ├── ui/
│       │   │   │   └── api/
│       │   │   └── common/
│       │   │       └── hooks/
│       │   │
│       │   ├── utilities/
│       │   │   ├── browser/
│       │   │   ├── api/
│       │   │   └── common/
│       │   │
│       │   └── data/
│       │       ├── siteA/
│       │       └── siteB/
│       │
│       └── resources/
│           ├── features/
│           │   ├── siteA/
│           │   │   ├── ui/
│           │   │   └── api/
│           │   ├── siteB/
│           │   │   ├── ui/
│           │   │   └── api/
│           │   └── common/
│           └── testdata/
│
└── target/
    └── ExtentReports/


---

⚙ Как это работает

Уровень	Назначение

core/	всё общее: BaseTest, DriverFactory, ConfigReader
ui/	Selenium логика (PageObjects, Actions, Waits)
api/	RestAssured, payload-builders, endpoints
runners/	отдельные CucumberRunner для каждого сайта и типа тестов
features/	отдельные .feature файлы по сайтам и типам тестов
steps/	StepDefinitions, разделённые по сайтам
reporting/	ExtentReports и Cucumber hooks
utilities/	вспомогательные классы: дата, JSON, скриншоты и т.д.



---

🚀 Как вы будете запускать

🔹 UI для SiteA

mvn test -Dtest=runners.siteA.UISiteARunner

🔹 API для SiteB

mvn test -Dtest=runners.siteB.APISiteBRunner

🔹 Общий регресс (все сайты, все типы)

mvn test -Dtest=runners.common.RegressionRunner


---

💡 Когда добавите Database

Вы просто создадите:

src/main/java/db/
src/test/java/steps/siteA/db/
src/test/resources/features/siteA/db/

и добавите свой DBSiteARunner.java — не ломая архитектуру
