plugins {
    id("java")
    id("org.gradle.test-retry") version "1.6.4"
}

java {
    sourceCompatibility = JavaVersion.VERSION_24
    targetCompatibility = JavaVersion.VERSION_24
}

group = "tracker"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.7.10")
    implementation("org.flywaydb:flyway-core:12.1.1")
    implementation("org.flywaydb:flyway-database-postgresql:12.1.1")
    implementation("org.springframework.boot:spring-boot-starter-flyway:4.0.3") // позволяет конфигурации application.yaml видеть проперти flyway

//    implementation("org.sprsingframework.boot:spring-boot-configuration-processor:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-web:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-actuator:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:4.0.3") // позволяет конфигурировать связи many-to-many и динамические запросы к бд

    compileOnly("org.projectlombok:lombok:1.18.44") // ломбок надо подключать с компайл-аннотаций, иначе нельзя будет использовать их генератор конструкций для бинов
    annotationProcessor("org.projectlombok:lombok:1.18.44")

    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-jdbc-test:4.0.3")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.testcontainers:testcontainers:2.0.4")
    testImplementation("org.testcontainers:testcontainers-postgresql:2.0.4")
    testImplementation("org.testcontainers:testcontainers-junit-jupiter:2.0.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    retry {
        maxRetries.set(2)
        failOnPassedAfterRetry.set(false)

        filter {
            includeAnnotationClasses.add("tracker.common.RerunIfFailed")
        }
    }
}
