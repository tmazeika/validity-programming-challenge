plugins {
    java
}

group = "me.mazeika.validity"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
}
