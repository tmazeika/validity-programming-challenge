plugins {
    application
    java
}

group = "me.mazeika.validity"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    compile("org.apache.commons:commons-text:1.8")

    testCompile("junit:junit:4.12")
}

application.mainClassName = "me.mazeika.validity.Validity"

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
}
