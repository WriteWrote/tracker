plugins {
    id("java")
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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.flywaydb:flyway-core:12.1.1")
    implementation("org.flywaydb:flyway-database-postgresql:12.1.1")
    implementation("org.postgresql:postgresql:42.7.10")

//    implementation("org.sprsingframework.boot:spring-boot-configuration-processor:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-web:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-flyway:4.0.3") // позволяет конфигурации application.yaml видеть проперти flyway
}

tasks.test {
    useJUnitPlatform()
}