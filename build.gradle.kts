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
    compile("commons-codec:commons-codec:1.13")
    compile("com.sparkjava:spark-core:2.9.1")
    compile("org.freemarker:freemarker:2.3.20")
    compile("org.slf4j:slf4j-simple:1.7.28")

    testCompile("junit:junit:4.12")
}

application.mainClassName = "me.mazeika.validity.Validity"

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
}
