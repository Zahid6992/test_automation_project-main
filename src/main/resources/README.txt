# Entwicklungsumgebung und Tools
1- Maven muss bereits installiert werden und MAVEN_HOME Pfad gesetzt. Maven Version Apache Maven 3.6.3 ist empfohlen
2- JAVA JDK 8 installieren und JAVA_HOME Pfad setzen
3- Docker installieren
4- Bevor der Testausführung, muss Zalenium Container gepulled werden. Anleitung dafür finden Sie unter diesem Link:
https://opensource.zalando.com/zalenium/
5- Die Tests können nur von TestNG XML Datei ausgeführt werden

   docker pull dosel/zalenium

    # Run it!
    docker run --rm -ti --name zalenium -p 4444:4444 \
      -e PULL_SELENIUM_IMAGE=true \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /Users/oussamabenmahmoud/videoszalenium:/home/seluser/videos \
      --privileged dosel/zalenium start